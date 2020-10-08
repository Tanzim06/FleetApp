package com.project.fleetapp.controllers;

import com.project.fleetapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class ProfileController{

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/profile", method= RequestMethod.GET)
    public String profile(Model model, Principal principal){

        String username= principal.getName();

        model.addAttribute("employee", employeeService.findByUsername(username));

        return "profile";
    }
}
