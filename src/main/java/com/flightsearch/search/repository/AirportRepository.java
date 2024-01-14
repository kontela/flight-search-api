package com.flightsearch.search.repository;

import com.flightsearch.search.model.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport,String> {
}
