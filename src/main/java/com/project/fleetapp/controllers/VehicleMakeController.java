package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleMakeController {
	
	@RequestMapping(value="/vehicle_make", method=RequestMethod.GET)
	public String getVehicleMake() {
		return "vehicle_make";
	}
}
