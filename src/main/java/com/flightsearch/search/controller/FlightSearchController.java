package com.flightsearch.search.controller;

import com.flightsearch.search.dto.FlightFilter;
import com.flightsearch.search.model.Flight;
import com.flightsearch.search.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Flight Search")
public class FlightSearchController {

    private final FlightService flightService;

    @Autowired
    public FlightSearchController(FlightService flightService) {
        this.flightService = flightService;
    }
    @ApiOperation(value = "Search for flights", notes = "Returns one way or two way flight information based on the search criteria. "+
                                                        "When all required criteria are given; "+
                                                        "If return date optional criteria is fulfilled then two way flight information is being returned "+
                                                        "If return date optioanl criteria is not fulfilled then one way flight information is being returned")
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> flightSearchController(@ModelAttribute FlightFilter filter){
        List<Flight> flights =flightService.searchFlight(filter);
        return ResponseEntity.ok(flights);

    }

}
