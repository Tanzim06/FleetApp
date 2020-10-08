package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;

	@RequestMapping(value="/employeeTypes", method=RequestMethod.GET)
	public String getEmployeeTypes(Model model) {

		List<EmployeeType> employeeTypeList= employeeTypeService.getEmployeeTypes();

		model.addAttribute("employeeTypes", employeeTypeList);

		return "employeeType";
	}


	@RequestMapping(value = "/employeeTypes/addNew", method = RequestMethod.POST)
	public String addNew(EmployeeType employeeType) {

		employeeTypeService.save(employeeType);

		return "redirect:/employeeTypes";
	}


	@RequestMapping(value="/employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeService.findById(id);
	}


	@RequestMapping(value="/employeeTypes/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {

		employeeTypeService.save(employeeType);

		return "redirect:/employeeTypes";
	}

	@RequestMapping(value="/employeeTypes/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		employeeTypeService.delete(id);

		return "redirect:/employeeTypes";
	}

	/*@RequestMapping(value="/employeeTypes", method=RequestMethod.GET)
	public String getEmployeeType() {
		return "employee_type";
	}*/
}