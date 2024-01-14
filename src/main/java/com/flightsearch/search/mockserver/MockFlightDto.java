package com.flightsearch.search.mockserver;

import com.flightsearch.search.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MockFlightDto {
    private String originAirport;
    private String destinationAirport;
    private LocalDate departureDate;
    private int price;

}
