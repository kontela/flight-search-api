package com.flightsearch.search.mockserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockFlightApiController {

    private final MockFlightService flightReturnService;

    @Autowired
    public MockFlightApiController(MockFlightService flightReturnService) {
        this.flightReturnService = flightReturnService;
    }

    @GetMapping("/mockapi/flights/data")
    public ResponseEntity<MockFlightDto> getMockFlightData() {
            MockFlightDto mockFlightDto= flightReturnService.createMockFlight();

        return ResponseEntity.ok(mockFlightDto);
    }
}
