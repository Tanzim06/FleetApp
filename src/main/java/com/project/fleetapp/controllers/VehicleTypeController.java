package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleTypeController {
	
	@RequestMapping(value="/vehicle_type", method=RequestMethod.GET)
	public String getVehicleStatus() {
		return "vehicle_type";
	}
}
