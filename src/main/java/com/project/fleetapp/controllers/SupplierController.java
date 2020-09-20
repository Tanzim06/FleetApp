package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SupplierController {
	
	@RequestMapping(value="/supplier", method=RequestMethod.GET)
	public String getSupplier() {
		return "supplier";
	}
}
