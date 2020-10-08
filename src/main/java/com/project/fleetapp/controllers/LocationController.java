package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.Location;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private LocationService locationService;

	@RequestMapping(value="/locations", method=RequestMethod.GET)
	public String getLocations(Model model) {

		List<State> stateList= stateService.getStates();

		model.addAttribute("states", stateList);

		List<Country> countryList= countryService.getCountries();

		model.addAttribute("countries", countryList);

		List<Location> locationList= locationService.getLocations();

		model.addAttribute("locations", locationList);

		return "location";
	}


	@RequestMapping(value = "/locations/addNew", method = RequestMethod.POST)
	public String addNew(Location location) {

		locationService.save(location);

		return "redirect:/locations";
	}


	@RequestMapping(value="/locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		return locationService.findById(id);
	}


	@RequestMapping(value="/locations/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location) {

		locationService.save(location);

		return "redirect:/locations";
	}

	@RequestMapping(value="/locations/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		locationService.delete(id);

		return "redirect:/locations";
	}

	
	/*@RequestMapping(value="/locations", method=RequestMethod.GET)
	public String getJobTitle() {
		return "location";
	}*/
}