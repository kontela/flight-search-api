package com.flightsearch.search.service;

import com.flightsearch.search.dto.MockFlight;
import com.flightsearch.search.model.Airport;
import com.flightsearch.search.model.Flight;
import com.flightsearch.search.repository.AirportRepository;
import com.flightsearch.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightClientService {

    private RestTemplate restTemplate;
    private String mockApiUrl = "http://localhost:8080/mockapi/flights/data";
    private FlightRepository flightRepository;
    private AirportRepository airportRepository;
    @Autowired
    public FlightClientService(RestTemplate restTemplate, FlightRepository flightRepository, AirportRepository airportRepository) {
        this.restTemplate = restTemplate;
        this.flightRepository=flightRepository;
        this.airportRepository=airportRepository;
    }

    @Scheduled(cron = "19 8 7 * * *")
    public void fetchFlightData() {

        System.out.println("Mock API request is being sent");
        MockFlight mockFlight = restTemplate.getForObject(mockApiUrl, MockFlight.class);

        if (mockFlight != null) {
            System.out.println("Respond is being received");
            flightRepository.save(convertToFlight(mockFlight));
        }
    }

    private Flight convertToFlight(MockFlight mockFlight) {
        Flight flight = new Flight();

        Airport originAirport=airportRepository.findById(mockFlight.getOriginAirport())
                .orElseThrow(() -> new RuntimeException("Airport not found"));

        Airport destinationAirport=airportRepository.findById(mockFlight.getDestinationAirport())
                .orElseThrow(() -> new RuntimeException("Airport not found"));


        flight.setOriginAirport(originAirport);
        flight.setDestinationAirport(destinationAirport);
        flight.setDepartureDate(mockFlight.getDepartureDate());

        return flight;
    }


}
