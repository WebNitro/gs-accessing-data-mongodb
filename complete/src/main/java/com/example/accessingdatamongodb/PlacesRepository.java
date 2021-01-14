package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webnitro.places.common.model.Place;

public interface PlacesRepository extends MongoRepository<Place, String> {

	/*
	 * public ATPlace findName(String firstName); public List<ATPlace>
	 * findName(String lastName);
	 */

}
