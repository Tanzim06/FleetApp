package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleMovementController {

	@RequestMapping(value="/vehicle_movement", method=RequestMethod.GET)
	public String getVehicleModel() {
		return "vehicle_movement";
	}
}
