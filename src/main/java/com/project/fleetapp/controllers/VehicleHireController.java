package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleHireController {
	
	@RequestMapping(value="/vehicle_hire", method=RequestMethod.GET)
	public String getVehicleHire() {
		return "vehicle_hire";
	}
}
