package com.flightsearch.search.mockserver;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MockFlightService {

    public MockFlightDto createMockFlight(){

        MockFlightDto mockFlightDto= new MockFlightDto();

        mockFlightDto.setOriginAirport("BER");
        mockFlightDto.setDestinationAirport("FCO");
        mockFlightDto.setDepartureDate(LocalDate.now().plusDays(10)); // Example: 10 days from today
        mockFlightDto.setPrice(ThreadLocalRandom.current().nextInt(30, 300));

        return mockFlightDto;

    }

}
