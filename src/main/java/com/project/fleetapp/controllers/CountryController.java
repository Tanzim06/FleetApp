package com.project.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.services.CountryService;


@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/countries", method=RequestMethod.GET)
	public String getCountries(Model model) {
		
		List<Country> countryList= countryService.getCountries();
		
		model.addAttribute("countries", countryList);
		
		return "country";
	}
	
	
	@RequestMapping(value = "/countries/addNew", method = RequestMethod.POST)
	public String addNew(Country country) {
		
		countryService.save(country);
		
		return "redirect:/countries";
	}
	
	
	@RequestMapping(value="/countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id) {
	  return countryService.findById(id);
	}
	
	
	@RequestMapping(value="/countries/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		
		countryService.save(country);
		
		return "redirect:/countries";
	}

	@RequestMapping(value="/countries/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {
		
		countryService.delete(id);
		
		return "redirect:/countries";
	}
}
