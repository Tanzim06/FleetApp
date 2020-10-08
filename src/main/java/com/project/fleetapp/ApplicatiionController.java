package com.project.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicatiionController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String goHome() {
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/logout")
	public String logout(){
		return "logout";
	}

	@GetMapping("/register")
	public String register(){
		return "register";
	}
}
