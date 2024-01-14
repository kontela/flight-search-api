package com.flightsearch.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@ApiModel(description = "Filter criteria for searching flights")
public class FlightFilter {

    @NotBlank(message = "Origin is required")
    @Size(min = 3, max = 3, message = "Airport code must be exactly 3 character IATA code")
    @ApiModelProperty(notes = "The IATA code for the origin airport of the flight", required = true, example = "BCN")
    private String origin;
    @NotBlank(message = "Destination is required")
    @Size(min = 3, max = 3, message = "Airport code must be exactly 3 character IATA code")
    @ApiModelProperty(notes = "The IATA code for the destination airport of the flight", required = true, example = "BER")
    private String destination;

    @NotNull(message = "Date is required")
    @Future
    @ApiModelProperty(notes = "The departure date for the flight", required = true, example = "2024-12-05")
    private LocalDate departureDate;

    @Future
    @ApiModelProperty(notes = "The return date for the flight, optional", required = false, example = "2024-12-09")
    private LocalDate returnDate;

    public boolean hasReturnFlight() {
        return this.returnDate != null;
    }

}
