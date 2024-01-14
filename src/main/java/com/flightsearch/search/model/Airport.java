package com.flightsearch.search.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Airport {
    @Id
    @Column(name = "iata_code", length = 3)
    private String iataCode;  // IATA code as primary key

    @Column(name="city")
    private String city;

}
