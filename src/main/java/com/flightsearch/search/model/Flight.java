package com.flightsearch.search.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="origin_ap", referencedColumnName = "iata_code")
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name="destination_ap", referencedColumnName = "iata_code")
    private Airport destinationAirport;

    @Column(name="departure_date")
    private LocalDate departureDate;

    @Column(name="price")
    private int price;

}
