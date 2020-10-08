package com.project.fleetapp.controllers;

import com.project.fleetapp.models.User;
import com.project.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getUser() {
		return "user";
	}

	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir){
		userService.save(user);
		RedirectView redirectView= new RedirectView("/login", true);
		redir.addFlashAttribute("message", "Registration successful, login now!");

		return redirectView;
	}
}
