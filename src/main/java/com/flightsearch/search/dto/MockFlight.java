package com.flightsearch.search.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class MockFlight {
        private String originAirport;
        private String destinationAirport;
        private LocalDate departureDate;
        private int price;

    }


