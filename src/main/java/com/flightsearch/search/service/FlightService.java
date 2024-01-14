package com.flightsearch.search.service;

import com.flightsearch.search.dto.FlightFilter;
import com.flightsearch.search.model.Flight;
import com.flightsearch.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {


    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    public List<Flight> searchFlight(FlightFilter filter) {
        List<Flight> flights = new ArrayList<Flight>();

        Optional<Flight> initialFlight = searchSingleFlightByFilter(filter);

        if (initialFlight.isPresent()){
            flights.add(initialFlight.get());

            if (filter.hasReturnFlight()){
                FlightFilter returnFlightFilter= createFilterForReturnFlight(filter);
                Optional<Flight> returnFlight = searchSingleFlightByFilter(returnFlightFilter);
                returnFlight.ifPresent(flights::add);
            }
        }

        return flights;
    }

    private Optional<Flight> searchSingleFlightByFilter(FlightFilter filter) {
        List<Flight> flights =flightRepository.searchFlightsByOriginDestinationAndDate(filter.getOrigin(),filter.getDestination(),filter.getDepartureDate());

        if (flights.isEmpty() || flights.size() > 1) {
            return Optional.empty();
        }

        return Optional.of(flights.get(0));

    }

    private FlightFilter createFilterForReturnFlight(FlightFilter originalFilter) {
        FlightFilter returnFlightFilter = new FlightFilter();

        returnFlightFilter.setOrigin(originalFilter.getDestination());
        returnFlightFilter.setDestination(originalFilter.getOrigin());
        returnFlightFilter.setDepartureDate(originalFilter.getReturnDate());

        return returnFlightFilter;
    }

}

