package com.example.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webnitro.places.common.model.ATPlace;
import com.webnitro.places.common.model.Place;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private PlacesRepository placesRepository;
	
    @Autowired
    private ATPlaceRepository atplacesRepository;
	 
	
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		System.out.println();
		placesRepository.deleteAll();
		/*
		// fetch all ATPlaces MySql
		System.out.println("ATPlaces found with findAll():");
		System.out.println("-------------------------------");
		for (ATPlace atplace : atplacesRepository.findAll()) {
			System.out.println(atplace);
			Place newPlace = new Place(atplace);
			placesRepository.save(newPlace);
		}
		System.out.println();

		  System.out.println("----------Places---------------------");
		  for (Place aPlace : placesRepository.findAll()) {
			  System.out.println(aPlace);
			  }
		  System.out.println();
		*/ 
	}
}
