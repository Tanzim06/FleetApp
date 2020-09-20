package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JobTitleController {
	@RequestMapping(value="/job_title", method=RequestMethod.GET)
	public String getJobTitle() {
		return "job_title";
	}
}
