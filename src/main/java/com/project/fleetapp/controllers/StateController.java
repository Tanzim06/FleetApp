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
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/states", method=RequestMethod.GET)
	public String getStates(Model model) {
		
		List<State> stateList= stateService.getStates();
		State s= stateList.get(0);
		model.addAttribute("states", stateList);
		//System.out.println(stateList.get(1));
		//stateList.forEach(n -> System.out.println(n)); 
		
        List<Country> countryList= countryService.getCountries();
		
		model.addAttribute("countries", countryList);
		return "state";
	}
	
	
	@RequestMapping(value = "/states/addNew", method = RequestMethod.POST)
	public String addNew(State state) {
		
		stateService.save(state);
		
		return "redirect:/states";
	}
	
	
	@RequestMapping(value="/states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
	  return stateService.findById(id);
	}
	
	
	@RequestMapping(value="/states/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(State state) {
		
		stateService.save(state);
		
		return "redirect:/states";
	}

	@RequestMapping(value="/states/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {
		
		stateService.delete(id);
		
		return "redirect:/states";
	}
	
	/*@RequestMapping(value="/state", method=RequestMethod.GET)
	public String getState() {
		return "state";
	}*/
}
