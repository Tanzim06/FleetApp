package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Employee;
import com.project.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class EmployeeController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private JobTitleService jobTitleService;


	@Autowired
	private EmployeeTypeService employeeTypeService;


	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public String getEmployees(Model model) {

		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());



		return "employee";
	}


	@RequestMapping(value = "/employees/addNew", method = RequestMethod.POST)
	public String addNew(Employee employee) {

		employeeService.save(employee);

		return "redirect:/employees";
	}


	@RequestMapping(value="/employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id) {
		return employeeService.findById(id);
	}


	@RequestMapping(value="/employees/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {

		employeeService.save(employee);

		return "redirect:/employees";
	}

	@RequestMapping(value="/employees/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {

		employeeService.delete(id);

		return "redirect:/employees";
	}


	@RequestMapping(value="/employees/assignUsername")
	public String assignUsername(int id){
		employeeService.assignUsername(id);

		return "redirect:/employees";
	}




	/*@RequestMapping(value="/employees", method=RequestMethod.GET)
	public String getEmployees() {
		return "employees";
	}*/
}
