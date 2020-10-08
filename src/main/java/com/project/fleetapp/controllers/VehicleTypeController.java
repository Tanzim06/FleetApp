package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.VehicleType;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@RequestMapping(value="/vehicleTypes", method=RequestMethod.GET)
	public String getVehicleTypes(Model model) {

		List<VehicleType> vehicleTypeList= vehicleTypeService.getVehicleTypes();

		model.addAttribute("vehicleTypes", vehicleTypeList);

		return "vehicleType";
	}


	@RequestMapping(value = "/vehicleTypes/addNew", method = RequestMethod.POST)
	public String addNew(VehicleType vehicleType) {

		vehicleTypeService.save(vehicleType);

		return "redirect:/vehicleTypes";
	}


	@RequestMapping(value="/vehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);
	}


	@RequestMapping(value="/vehicleTypes/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {

		vehicleTypeService.save(vehicleType);

		return "redirect:/vehicleTypes";
	}

	@RequestMapping(value="/vehicleTypes/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleTypeService.delete(id);

		return "redirect:/vehicleTypes";
	}
	
	/*@RequestMapping(value="/vehicle_type", method=RequestMethod.GET)
	public String getVehicleStatus() {
		return "vehicle_type";
	}*/
}
