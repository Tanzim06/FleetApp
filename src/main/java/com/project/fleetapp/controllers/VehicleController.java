package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Vehicle;
import com.project.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class VehicleController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VehicleMakeService vehicleMakeService;

	@Autowired
	private VehicleStatusService vehicleStatusService;

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@Autowired
	private VehicleModelService vehicleModelService;

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value="/vehicles", method=RequestMethod.GET)
	public String getVehicles(Model model) {

		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("vehicles", vehicleService.getVehicles());



		return "vehicle";
	}


	@RequestMapping(value = "/vehicles/addNew", method = RequestMethod.POST)
	public String addNew(Vehicle vehicle) {

		vehicleService.save(vehicle);

		return "redirect:/vehicles";
	}


	@RequestMapping(value="/vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {
		return vehicleService.findById(id);
	}


	@RequestMapping(value="/vehicles/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {

		vehicleService.save(vehicle);

		return "redirect:/vehicles";
	}

	@RequestMapping(value="/vehicles/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {

		vehicleService.delete(id);

		return "redirect:/vehicles";
	}
	
	
	/*@RequestMapping(value="/vehicle", method=RequestMethod.GET)
	public String getState() {
		return "vehicle";
	}*/
}
