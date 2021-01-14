package com.webnitro.places.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.accessingdatamongodb.ATPlaceRepository;
import com.webnitro.places.common.model.ATPlace;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/places") // This means URL's start with /demo (after Application path)
public class PlaceController {
    @Autowired // This means to get the bean called placeRepository
    private ATPlaceRepository placeCrudRepository;
    
    


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewPlace (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

    	
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());


        ATPlace n = new ATPlace("Unknown");
        n.setName(name);
      
        n.setEmail(email);
        n.setLastUpdated(currentTimestamp.toString());
        placeCrudRepository.save(n);
        return "Saved: "+ name + ".";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ATPlace> getAllATPlaces() {
        // This returns a JSON or XML with the ATPlaces
        return placeCrudRepository.findAll();
    }

    @GetMapping(path="/place/{id}")
   public String getATPlacebyID(@PathVariable("id") int id, Model model) {
        // This returns a JSON or XML with the ATPlace matching id
    	
    	
		ATPlace placeToFind;
    	try {     		  
            // get the value 
    		placeToFind = placeCrudRepository.findById(id).get();
    		model.addAttribute("place", placeToFind);
    		model.addAttribute("title", placeToFind.getName());   		
    	}
        catch (NoSuchElementException e) { 
    		model.addAttribute("place", new ATPlace("Not Found"));
    		model.addAttribute("title", "Place not Found");
        }    		
		return "updateplace";
    }
    
    
    @GetMapping(path="/nearbyplace/{id}")
   public String getPlacesNearbyPlaceID(@PathVariable("id") int id, Model model) {
        // This returns a JSON or XML with the ATPlace matching id
    	
    	
		ATPlace placeToFind;
    	try {     		  
            // get the value 
    		placeToFind = placeCrudRepository.findById(id).get();
    		model.addAttribute("place", placeToFind);
    		model.addAttribute("title", "Places nearby " + placeToFind.getName());   	
    		System.out.println(placeToFind.getName()); 
    		System.out.println("placeToFind.getLat(): " +placeToFind.getLat() + ", "+ "placeToFind.getLng(): " + placeToFind.getLng());
 //       	List<ATPlace> foundplaces  = placeCrudRepository.findAllNearLatLng(String.valueOf(placeToFind.getLat()), String.valueOf(placeToFind.getLng()));
 // working?       	List<ATPlace> foundplaces  = placeCrudRepository.findAllNearLatLng("35.1788014","-83.3743807");
        	List<ATPlace> foundplaces  = placeCrudRepository.findAllNearLatLng("35.1788014","-83.3743807");

        	long resultSize = (foundplaces.size());
    		model.addAttribute("places", foundplaces);
    		model.addAttribute("title", String.valueOf(resultSize) +" Found Places"); 
    		model.addAttribute("username", "jsmith"); 
    	}
        catch (NoSuchElementException e) { 
    		model.addAttribute("place", new ATPlace("Not Found"));
    		model.addAttribute("title", "Place not Found");
        }    		
    	
        return "allplaces";
    }
    
    

    @GetMapping(path="/boot")
    public String showBootStrap(Model model) {
    	return "bootstrap";
    }

    @GetMapping(path="/showall")
    public String  showAllATPlaces(Model model) {
    	List<ATPlace> foundplaces  = placeCrudRepository.findAll();
    	long resultSize = (foundplaces.size());
		model.addAttribute("places", foundplaces);
		model.addAttribute("title", String.valueOf(resultSize) +" Found Places"); 
		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }
    
    @GetMapping(path="/showallmeals")
    public String  showAllMeals(Model model) {
    	List<String> poitypes = new ArrayList<>();
    	poitypes.add("Meals");
    	poitypes.add("pizza");
    	poitypes.add("restaurant");
    	poitypes.add("grocery_or_supermarket");
    	List<ATPlace> foundplaces  = placeCrudRepository.findAllByPoiTypeIn(poitypes);
    	long resultSize = (foundplaces.size());
		model.addAttribute("places", foundplaces);
		model.addAttribute("title", String.valueOf(resultSize) +" Found Meal Places"); 
		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }
   
    @GetMapping(path="/meals")
    public String  getAlllMeals(Model model) {
/*    	List<String> poitypes = new ArrayList<>();
    	poitypes.add("Meals");
    	poitypes.add("pizza");
    	poitypes.add("restaurant");
    	poitypes.add("grocery_or_supermarket");
 */
    	List<ATPlace> foundplaces  = placeCrudRepository.getMeals();
    	long resultSize = (foundplaces.size());
		model.addAttribute("places", foundplaces);
		model.addAttribute("title", String.valueOf(resultSize) +" Found Meal Places"); 
		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }
   
    
    @GetMapping(path="/maildrops")
    public String  getAllMaildrops(Model model) {

    	List<ATPlace> foundplaces  = placeCrudRepository.getMailDrops();
    	long resultSize = (foundplaces.size());
		model.addAttribute("places", foundplaces);
		model.addAttribute("title", String.valueOf(resultSize) +" Found Maildrops"); 
		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }

    
    

    @GetMapping(path="/home")
    public String  showHome(Model model) {
    	List<ATPlace> foundplaces  = placeCrudRepository.findAll();
    	long resultSize = (foundplaces.size());

		model.addAttribute("places", foundplaces);
		model.addAttribute("title", String.valueOf(resultSize) +" Found Places"); 
		model.addAttribute("username", "jsmith"); 
        return "index";
    }
    @GetMapping(path="/nearby")
    public String  showNearby(Model model) {
    	Iterable<ATPlace> foundplaces  = placeCrudRepository.findAllNearGeopoint();
		model.addAttribute("places", foundplaces);
		model.addAttribute("title", "Found Places nearby"); 
		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }

    //findAllNearLatLng
    
    @GetMapping(path="/type/{poitype}")
    public String  findbyType(Model model, @PathVariable("poitype") String poitype) {
    	List<ATPlace> foundplaces  = placeCrudRepository.findAllByPoiType(poitype);
    	long resultSize = (foundplaces.size());
		model.addAttribute("places", foundplaces);
		model.addAttribute("title", " Found " +String.valueOf(resultSize)+ " " + poitype + " places"); 

		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }

    @GetMapping(path="/name/{searchname}")
    public String  searchByName(Model model, @PathVariable("searchname") String searchname) {
    	List<ATPlace> foundplaces  = placeCrudRepository.findAllByNameContains(searchname);
    	long resultSize = (foundplaces.size());

		model.addAttribute("places", foundplaces);
		model.addAttribute("title", " Found " +String.valueOf(resultSize)+ " " + searchname + " places"); 

		model.addAttribute("username", "jsmith"); 
        return "allplaces";
    }

    
    
    @DeleteMapping(path="/place/{id}")
    ResponseEntity<String> deleteATPlacebyID(@PathVariable("id") int id) {
        // This deletes the ATPlace matching id

        String result = new String();
        HttpStatus status;

        if (placeCrudRepository.existsById(id)) {
        	placeCrudRepository.deleteById(id);
            result = "Deleted: "+ id + ".";
            status = HttpStatus.OK;
        }
        else {
            result = "Id Not found: "+ id + ".";
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<> (result, status);
    }

    /*

    @GetMapping(path="/count")
    public @ResponseBody
    Optional Integer getATPlaceCount) {
        // This returns a JSON or XML with the ATPlace matching id

        return placeRepository.count();
    }
    
    */

    @PutMapping(path="/place/{id}") // Map ONLY PUT Requests
    public @ResponseBody String saveATPlace (@PathVariable Integer id, @RequestParam String name,
                                          @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Boolean isExistingATPlace = placeCrudRepository.existsById(id);

        ATPlace savedATPlace = new ATPlace("Unknown");
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        if (isExistingATPlace) {
            ATPlace existingATPlace = placeCrudRepository.findById(id).get();
            existingATPlace.setName(name);
            existingATPlace.setEmail(email);
            
    		existingATPlace.setLastUpdated(currentTimestamp.toString());
    		
            savedATPlace = placeCrudRepository.save(existingATPlace);
        }
        else {

            ATPlace newATPlace = new ATPlace("Unknown");
            newATPlace.setName(name);
            newATPlace.setEmail(email);
            newATPlace.setLastUpdated(currentTimestamp.toString());
            savedATPlace = placeCrudRepository.save(newATPlace);
        }
        return "Saved: "+ savedATPlace.getName() + ", "+ savedATPlace.getId() + ".";
    }
    
    @PutMapping("/placeupdate")
    public String submitForm(@ModelAttribute("place") ATPlace updatedPlace, Model model) {
        System.out.println(updatedPlace);
        return "resultplace";
    }
    
    @PutMapping(path="/saveplace")
    public String savePlace(@ModelAttribute ATPlace updatedPlace, Model model) {
  //      model.addAttribute("place", updatedPlace);
    	System.out.println(updatedPlace.toString());

        Integer id = updatedPlace.getId();
        Boolean isExistingATPlace = placeCrudRepository.existsById(id);

        ATPlace savedATPlace = new ATPlace("Unknown");
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        if (isExistingATPlace) {
            ATPlace existingATPlace = placeCrudRepository.findById(id).get();
            existingATPlace.setName(updatedPlace.getName());
            existingATPlace.setEmail(updatedPlace.getEmail());
            
    		existingATPlace.setLastUpdated(currentTimestamp.toString());
    		
            savedATPlace = placeCrudRepository.save(existingATPlace);
        }
        else {

            ATPlace newATPlace = new ATPlace("Unknown");
            newATPlace.setName(updatedPlace.getName());
            newATPlace.setEmail(updatedPlace.getEmail());
            newATPlace.setLastUpdated(currentTimestamp.toString());
            savedATPlace = placeCrudRepository.save(newATPlace);
        }
        return "Saved: "+ savedATPlace.getName() + ", "+ savedATPlace.getId() + ".";
    }
    
    @PostMapping("/saveatplace")
    public String saveATPlace(@ModelAttribute("place") ATPlace place, Model model) {
    	System.out.println("/saveatplace");
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		place.setLastUpdated(currentTimestamp.toString());
        System.out.println(place);
		model.addAttribute("title", place.getName());  
        return "resultplace";
    }
    
    
    @GetMapping("/updateatplace")
    public String showPlaceForm(Model model) {
    	

        int id = 3747;
		ATPlace placeToFind;
		if (placeCrudRepository.findById(id).isPresent()) {
			System.out.println(id + " is present");
//    	try {     		  
            // get the value 
    		
    		placeToFind = placeCrudRepository.findById(id).get();
    		model.addAttribute("place", placeToFind);
    		model.addAttribute("title", placeToFind.getName());   		
 //   	}
//        catch (NoSuchElementException e) { 
 //       catch (Exception e) { 

  // /  		model.addAttribute("place", new ATPlace("Exception so Not Found"));
  // /  		model.addAttribute("title", "Place not Found");
  //      }  
		} else {
			System.out.println(id + " is not present");
    		model.addAttribute("place", new ATPlace("Exception so Not Found"));
    		model.addAttribute("title", "Place not Found");

        }
         
//        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
 //       model.addAttribute("listProfession", listProfession);
		
        return "updateplace";
    }
   

    @GetMapping("/placedetails/{id}")
    public String showPlaceDetails(@PathVariable("id") int id, @ModelAttribute("place") ATPlace place, Model model) {
		ATPlace placeToFind;
		System.out.println(id);
//    	try {     		  
            // get the value 
		  boolean isValidPlace = placeCrudRepository.existsById(id);
		  System.out.println(id + "exists:" +isValidPlace);
		  Optional<ATPlace> foo = placeCrudRepository.findById(id);
    		placeToFind = foo.get();
    		model.addAttribute("place", placeToFind);
    		model.addAttribute("title", placeToFind.getName());   		
/*    	}
//        catch (NoSuchElementException e) { 
        catch (Exception e) { 
        	System.out.println("Exception for "+id+" was:\n"+ e.toString());
        	System.out.println("\n"+ e.getStackTrace().toString());
    		model.addAttribute("place", new ATPlace("Not Found"));
    		model.addAttribute("title", "Place not Found");
        }  */  	
        System.out.println(place);
		model.addAttribute("place", place);
		model.addAttribute("title", place.getName());  
        return "resultplace";
    }
    

   
    /*
     * package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
     */

}
