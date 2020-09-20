package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleStatusController {
	
	@RequestMapping(value="/vehicle_status", method=RequestMethod.GET)
	public String getVehicleStatus() {
		return "vehicle_status";
	}
}
