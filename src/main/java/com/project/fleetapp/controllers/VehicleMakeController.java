package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.VehicleMake;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

	@Autowired
	private VehicleMakeService vehicleMakeService;

	@RequestMapping(value="/vehicleMakes", method=RequestMethod.GET)
	public String getVehicleMakes(Model model) {

		List<VehicleMake> vehicleMakeList= vehicleMakeService.getVehicleMakes();

		model.addAttribute("vehicleMakes", vehicleMakeList);

		return "vehicleMake";
	}


	@RequestMapping(value = "/vehicleMakes/addNew", method = RequestMethod.POST)
	public String addNew(VehicleMake vehicleMake) {

		vehicleMakeService.save(vehicleMake);

		return "redirect:/vehicleMakes";
	}


	@RequestMapping(value="/vehicleMakes/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeService.findById(id);
	}


	@RequestMapping(value="/vehicleMakes/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {

		vehicleMakeService.save(vehicleMake);

		return "redirect:/vehicleMakes";
	}

	@RequestMapping(value="/vehicleMakes/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleMakeService.delete(id);

		return "redirect:/vehicleMakes";
	}
	
	/*@RequestMapping(value="/vehicle_make", method=RequestMethod.GET)
	public String getVehicleMake() {
		return "vehicle_make";
	}*/
}
