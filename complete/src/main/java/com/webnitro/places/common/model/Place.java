package com.webnitro.places.common.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="places")
public class Place {

	/*
	 * 

	INSERT INTO `myats`.`places-po`
	(`_id`,
	`place_name`,
	`place_lat`,
	`place_lng`,
	`place_formatted_address`,
	`place_formatted_phone_number`,
	`place_geometry_json`,
	`place_icon_uri`,
	`place_json`,
	`place_opening_hours_json`,
	`place_photos_json`,
	`place_id`,
	`place_rating`,
	`place_reviews_json`,
	`place_scope`,
	`place_types`,
	`place_url`,
	`place_user_ratings_total`,
	`place_vicinity`,
	`place_website`,
	`parent`)
	
		 */
	@Id
	@Field(name="_id")
	private String id;
	
	@Field(name="place_id")
	private String gPlaceID;
	
	@Field(name="place_name")
	private String name;
	
	@Field(name="place_lat")
	private Double lat=(double) 0;
	
	@Field(name="place_lng")
	private Double lng=(double) 0;
	
	@Field(name="place_url")		
	private String mapURL;
	
	@Field(name="place_formatted_phone_number")	
	private String phone;
	
	@Field(name="place_website")	
	private String website;
	
	@Field(name="email")
	private String email;
	
	@Field(name="description")
	private String description;
	
	@Field(name="parent")	
	private String town;
	
	@Field(name="dist_from_trail")	
	private String distanceOffAT;
	
	@Field(name="dir_from_trail")
	private String directionOffAT;
	
	@Field(name="distfromstart")
	private Double distanceNOBOFromSpringer= (double) 0;
	
	@Field(name="place_formatted_address")		
	private String address;
	
	@Field(name="poi_type")	
	private String poiType;
	
	@Field(name="photo_url")	
	private String photoURL;
	
	// TODO: Fix gPhotos later
	//@Field(name="photo_url")	
	//private String gPhotos;
	
	@Field(name="place_opening_hours_json")	
	private String hours;
	
	@Field(name="elevation")	
	private String elevation;
	
	@Field(name="features")
	private String features;
	
	@Field(name="place_rating")
	private String rating;
	
	@Field(name="place_types")
	private String gPlaceTypes;
	
	@Field(name="place_icon_uri")
	private String gPlaceIconURL;
	
	@Field(name="place_reviews_json")
	private String gReviews;
	
	@Field(name="last_updated")
	private String lastUpdated;
	
	@Field(name="accepts_maildrops")
	private String acceptsMaildrops;
	
	@Field(name="is_hostel")
	private String isHostel;
	
	@Field(name="is_atpassport")
	private String isATpassport;
	
	@Field(name="has_shuttle")
	private String hasShuttle;
	
	@Field(name="has_camping")
	private String hasCamping;
	
	@Field(name="is_active")
	private String isActive;
	
	@Field(name="has_showers")
	private String hasShowers;
	
	@Field(name="has_laundry")
	private String hasLaundry;
	
	@Field(name="is_outfitter")
	private String isOutfitter;
	
	@Field(name="has_short_term_resupply")
	private String hasShortTermResupply;
	
	@Field(name="has_long_term_resupply")
	private String hasLongTermResupply;
	
	@Field(name="has_meals")
	private String hasMeals;
	
	@Field(name="has_internet")
	private String hasInternet;
	
	@Field(name="allows_pets")
	private String allowsPets;
		

/*
 * SELECT `wikitrail20160531`.`_id`,
    `wikitrail20160531`.`poi_name`,
    `wikitrail20160531`.`distfromstart`,
    `wikitrail20160531`.`elevation`,
    `wikitrail20160531`.`gps`,
    `wikitrail20160531`.`wiki_type`,
    `wikitrail20160531`.`features`,
    `wikitrail20160531`.`dist_from_trail`,
    `wikitrail20160531`.`dir_from_trail`,
    `wikitrail20160531`.`phone`,
    `wikitrail20160531`.`website`,
    `wikitrail20160531`.`address`,
    `wikitrail20160531`.`email`,
    `wikitrail20160531`.`parent`,
    `wikitrail20160531`.`description`,
    `wikitrail20160531`.`pictures`,
    `wikitrail20160531`.`last_updated`
FROM `myats`.`wikitrail20160531`;

SELECT 
  poi_name as place_name,
  distfromstart,
  elevation,
  SUBSTRING_INDEX(SUBSTRING_INDEX(gps, ',', 1), ',', -1) as place_lat,
  SUBSTRING_INDEX(SUBSTRING_INDEX(gps, ',', 2), ',', -1) as place_lng,
  wiki_type as poi_type,
  features,
  dist_from_trail,
  dir_from_trail,
  phone,
  website as place_website,
  address as place_formatted_address,
  email,
  parent,
  description,
  pictures,
  last_updated
FROM myats.wikitrail20160531;
 */


	public String getId() {
		
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getgPlaceID() {
		return gPlaceID;
	}




	public void setgPlaceID(String gPlaceID) {
		this.gPlaceID = gPlaceID;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Double getLat() {
		return lat;
	}




	public void setLat(Double lat) {
		this.lat = lat;
	}




	public Double getLng() {
		return lng;
	}




	public void setLng(Double lng) {
		this.lng = lng;
	}




	public String getMapURL() {
		return mapURL;
	}




	public void setMapURL(String mapURL) {
		this.mapURL = mapURL;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getWebsite() {
		return website;
	}




	public void setWebsite(String website) {
		this.website = website;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getTown() {
		return town;
	}




	public void setTown(String town) {
		this.town = town;
	}




	public String getDistanceOffAT() {
		return distanceOffAT;
	}




	public void setDistanceOffAT(String distanceOffAT) {
		this.distanceOffAT = distanceOffAT;
	}




	public Double getDistanceNOBOFromSpringer() {
		return distanceNOBOFromSpringer;
	}




	public void setDistanceNOBOFromSpringer(Double distanceNOBOFromSpringer) {
		this.distanceNOBOFromSpringer = distanceNOBOFromSpringer;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getPoiType() {
		return poiType;
	}




	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}




	public String getPhotoURL() {
		return photoURL;
	}




	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}




	public String getHours() {
		return hours;
	}




	public void setHours(String hours) {
		this.hours = hours;
	}




	public String getElevation() {
		return elevation;
	}




	public void setElevation(String elevation) {
		this.elevation = elevation;
	}




	public String getFeatures() {
		return features;
	}




	public void setFeatures(String features) {
		this.features = features;
	}




	public String getDirectionOffAT() {
		return directionOffAT;
	}




	public void setDirectionOffAT(String directionOffAT) {
		this.directionOffAT = directionOffAT;
	}




	public String getLastUpdated() {
		return lastUpdated;
	}




	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}




	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}




	public String getgPlaceTypes() {
		return gPlaceTypes;
	}




	public void setgPlaceTypes(String gPlaceTypes) {
		this.gPlaceTypes = gPlaceTypes;
	}




	public String getgPlaceIconURL() {
		return gPlaceIconURL;
	}




	public void setgPlaceIconURL(String gPlaceIconURL) {
		this.gPlaceIconURL = gPlaceIconURL;
	}



/*
	public String getgPhotos() {
		return gPhotos;
	}
*/


/*
	public void setgPhotos(String gPhotos) {
		this.gPhotos = gPhotos;
	}

*/



	public String getgReviews() {
		return gReviews;
	}




	public void setgReviews(String gReviews) {
		this.gReviews = gReviews;
	}




	public String getAcceptsMaildrops() {
		return acceptsMaildrops;
	}




	public void setAcceptsMaildrops(String acceptsMaildrops) {
		this.acceptsMaildrops = acceptsMaildrops;
	}




	public String getIsHostel() {
		return isHostel;
	}




	public void setIsHostel(String isHostel) {
		this.isHostel = isHostel;
	}




	public String getIsATpassport() {
		return isATpassport;
	}




	public void setIsATpassport(String isATpassport) {
		this.isATpassport = isATpassport;
	}




	public String getHasShuttle() {
		return hasShuttle;
	}




	public void setHasShuttle(String hasShuttle) {
		this.hasShuttle = hasShuttle;
	}


	public String getStringGPS() {
		String townLat = "0.0";
		String townLng = "0.0";
		
		if (getLat() != null) {
			 townLat = Double.toString(getLat());
		}
		if (getLat() != null) {
			townLng = Double.toString(getLng());	
		}

		return townLat+","+townLng;
	}

	public String getHasCamping() {
		return hasCamping;
	}




	public void setHasCamping(String hasCamping) {
		this.hasCamping = hasCamping;
	}




	public String getIsActive() {
		return isActive;
	}




	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}




	public String getHasShowers() {
		return hasShowers;
	}




	public void setHasShowers(String hasShowers) {
		this.hasShowers = hasShowers;
	}




	public String getIsOutfitter() {
		return isOutfitter;
	}




	public void setIsOutfitter(String isOutfitter) {
		this.isOutfitter = isOutfitter;
	}



	public String getHasMeals() {
		return hasMeals;
	}




	public void setHasMeals(String hasMeals) {
		this.hasMeals = hasMeals;
	}




	public String getHasInternet() {
		return hasInternet;
	}




	public void setHasInternet(String hasInternet) {
		this.hasInternet = hasInternet;
	}




	public String getHasLaundry() {
		return hasLaundry;
	}




	public void setHasLaundry(String hasLaundry) {
		this.hasLaundry = hasLaundry;
	}




	public String getHasShortTermResupply() {
		return hasShortTermResupply;
	}




	public void setHasShortTermResupply(String hasShortTermResupply) {
		this.hasShortTermResupply = hasShortTermResupply;
	}




	public String getHasLongTermResupply() {
		return hasLongTermResupply;
	}




	public void setHasLongTermResupply(String hasLongTermResupply) {
		this.hasLongTermResupply = hasLongTermResupply;
	}




	public String getAllowsPets() {
		return allowsPets;
	}




	public void setAllowsPets(String allowsPets) {
		this.allowsPets = allowsPets;
	}


	public Place() {
		super();
		this.name = "Unknown Place";
		this.lat = (double) 0;
		this.lng = (double) 0;
	}

	public Place(String placeName) {
		super();
		this.name = placeName;
		this.lat = (double) 0;
		this.lng = (double) 0;
	}
	

	public Place(String placeName, double placeLat, double placeLng) {
		super();
		this.lat = placeLat;
		this.lng = placeLng;
		this.name = placeName;
	}

	
	public Place(String name, double lat, double lng,String gPlaceID,
			String website) {
		super();
		this.gPlaceID = gPlaceID;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.website = website;
	}




	public Place(String id, String name, double lat, double lng) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
	}




	public Place(String id,  String name, double lat, double lng,  String gPlaceID) {
		super();
		this.id = id;
		this.gPlaceID = gPlaceID;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
	}

	public Place(String id,  String name, double lat, double lng,  String gPlaceID, String website) {
		super();
		this.id = id;
		this.gPlaceID = gPlaceID;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.website = website;
	}




	public Place(String id, String gPlaceID, String name, double lat,
			double lng, String mapURL, String phone, String website,
			String email) {
		super();
		this.id = id;
		this.gPlaceID = gPlaceID;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.mapURL = mapURL;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}



	public Place(String id, String name, double lat, double lng,
			String gPlaceID, String website, String mapURL) {
		this.id = id;
		this.gPlaceID = gPlaceID;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.website = website;
		this.mapURL = mapURL;
	}




	public Place(String name, double lat, double lng, String gPlaceID,
			String website, String mapURL) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.gPlaceID = gPlaceID;
		this.website = website;
		this.mapURL = mapURL;
	}




	public Place(ATPlace atplace) {
		super();
		this.acceptsMaildrops = atplace.getAcceptsMaildrops();
		this.address = atplace.getAddress();
		this.allowsPets = atplace.getAllowsPets();
		this.description = atplace.getDescription();
		this.directionOffAT = atplace.getDirectionOffAT();
		this.distanceNOBOFromSpringer = atplace.getDistanceNOBOFromSpringer();
		this.distanceOffAT = atplace.getDistanceOffAT();
		this.elevation = atplace.getElevation();
		this.email = atplace.getEmail();
		this.features = atplace.getFeatures();
		this.gPlaceIconURL = atplace.getgPlaceIconURL();
		this.gPlaceID = atplace.getgPlaceID();
		this.gPlaceTypes = atplace.getgPlaceTypes();
		this.gReviews = atplace.getgReviews();
		this.hasCamping = atplace.getHasCamping();
		this.hasInternet = atplace.getHasInternet();
		this.hasLaundry = atplace.getHasLaundry();
		this.hasLongTermResupply = atplace.getHasLongTermResupply();
		this.hasMeals = atplace.getHasMeals();
		this.hasShortTermResupply = atplace.getHasShortTermResupply();
		this.hasShowers = atplace.getHasShowers();
		this.hasShuttle = atplace.getHasShuttle();
		this.hours = atplace.getHours();
		this.isActive = atplace.getIsActive();
		this.isATpassport = atplace.getIsATpassport();
		this.isHostel = atplace.getIsHostel();
		this.isOutfitter = atplace.getIsOutfitter();
		this.lastUpdated = atplace.getLastUpdated();
		this.lat = atplace.getLat();
		this.lng = atplace.getLng();
		this.mapURL = atplace.getMapURL();
		this.name = atplace.getName();
		this.phone = atplace.getPhone();
		this.photoURL = atplace.getPhotoURL();
		this.poiType = atplace.getPoiType();
		this.rating = atplace.getRating();
		this.town = atplace.getTown();
		this.website = atplace.getWebsite();
		

	}




	@Override
	public String toString() {
		return "ATPlace [id=" + id + ", gPlaceID=" + gPlaceID + ", name=" + name + ", lat=" + lat + ", lng=" + lng
				+ ", mapURL=" + mapURL + ", phone=" + phone + ", website=" + website + ", email=" + email
				+ ", description=" + description + ", town=" + town + ", distanceOffAT=" + distanceOffAT
				+ ", directionOffAT=" + directionOffAT + ", distanceNOBOFromSpringer=" + distanceNOBOFromSpringer
				+ ", address=" + address + ", poiType=" + poiType + ", photoURL=" + photoURL + ", TODO gPhotos= + gPhotos"
				+ ", hours=" + hours + ", elevation=" + elevation + ", features=" + features + ", rating=" + rating
				+ ", gPlaceTypes=" + gPlaceTypes + ", gPlaceIconURL=" + gPlaceIconURL + ", gReviews=" + gReviews
				+ ", lastUpdated=" + lastUpdated + ", acceptsMaildrops=" + acceptsMaildrops + ", isHostel=" + isHostel
				+ ", isATpassport=" + isATpassport + ", hasShuttle=" + hasShuttle + ", hasCamping=" + hasCamping
				+ ", isActive=" + isActive + ", hasShowers=" + hasShowers + ", hasLaundry=" + hasLaundry
				+ ", isOutfitter=" + isOutfitter + ", hasShortTermResupply=" + hasShortTermResupply
				+ ", hasLongTermResupply=" + hasLongTermResupply + ", hasMeals=" + hasMeals + ", hasInternet="
				+ hasInternet + "]";
	}









}
