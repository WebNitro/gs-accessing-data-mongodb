package com.example.accessingdatamongodb;

import  com.webnitro.places.common.model.ATPlace;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ATPlaceRepository extends JpaRepository<ATPlace, Integer> {
	

List<ATPlace> findAllByName(String name);

List<ATPlace> findAllByPoiType(String poiType);

List<ATPlace> findAllByNameContains(String name);

List<ATPlace> findAllByTownContains(String town);

List<ATPlace> findAllByPoiTypeIn(List<String> poitypes);


//@Query(value = "SELECT id, place_name, AsText(geopoint), parent, place_lat, place_lng,  X(geopoint) AS 'latitude', Y(geopoint) AS 'longitude', Distance(geopoint, GeomFromText('POINT(36.63 -81.78)')) FROM myats.atplaces WHERE Distance(geopoint, GeomFromText('POINT(36.63 -81.78)')) < 0.1", nativeQuery = true)
@Query(value = "SELECT * FROM myats.atplaces WHERE Distance(geopoint, GeomFromText('POINT(36.63 -81.78)')) < 0.1", nativeQuery = true)
List<ATPlace> findAllNearGeopoint();
	
//@Query(value = "SELECT id, place_name, AsText(geopoint), parent, place_lat, place_lng,  X(geopoint) AS 'latitude', Y(geopoint) AS 'longitude', Distance(geopoint, GeomFromText('POINT(36.63 -81.78)')) FROM myats.atplaces WHERE Distance(geopoint, GeomFromText('POINT(36.63 -81.78)')) < 0.1", nativeQuery = true)
@Query(value = "SELECT * FROM myats.atplaces WHERE Distance(geopoint, GeomFromText('POINT(:lat :lng)')) < 0.1", nativeQuery = true)
List<ATPlace> findAllNearLatLng(@Param("lat") String lat,@Param("lng") String lng );


//@Param("lng") BigDecimal lng)


@Query(value = "SELECT * FROM atplaces WHERE (poi_type in ('Meals', 'pizza', 'restaurant', 'grocery_or_supermarket') or (has_meals = 'Y'))", nativeQuery = true)
List<ATPlace> getMeals();


@Query(value = "SELECT * FROM atplaces WHERE ((accepts_maildrops = 'Y'))", nativeQuery = true)
List<ATPlace> getMailDrops();



}
	


