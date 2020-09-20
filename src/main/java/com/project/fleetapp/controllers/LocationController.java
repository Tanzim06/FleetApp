package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationController {
	
	@RequestMapping(value="/location", method=RequestMethod.GET)
	public String getJobTitle() {
		return "location";
	}
}