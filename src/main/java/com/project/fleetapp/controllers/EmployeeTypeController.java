package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeTypeController {

	@RequestMapping(value="/employee_type", method=RequestMethod.GET)
	public String getEmployeeType() {
		return "employee_type";
	}
}