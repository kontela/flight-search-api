package com.flightsearch.search.repository;

import com.flightsearch.search.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.originAirport.iataCode = :origin AND f.destinationAirport.iataCode = :destination AND f.departureDate = :departureDate")
    List<Flight> searchFlightsByOriginDestinationAndDate(String origin, String destination, LocalDate departureDate);
}
