package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleController {
	
	@RequestMapping(value="/vehicle", method=RequestMethod.GET)
	public String getState() {
		return "vehicle";
	}
}
