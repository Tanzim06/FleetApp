package com.project.fleetapp.controllers;

import com.project.fleetapp.models.VehicleMovement;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.SupplierService;
import com.project.fleetapp.services.VehicleMovementService;
import com.project.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private LocationService locationService;

	@RequestMapping(value="/vehicleMovements", method=RequestMethod.GET)
	public String getVehicleMovements(Model model) {

		model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());

		return "vehicleMovement";
	}


	@RequestMapping(value = "/vehicleMovements/addNew", method = RequestMethod.POST)
	public String addNew(VehicleMovement vehicleMovement) {

		vehicleMovementService.save(vehicleMovement);

		return "redirect:/vehicleMovements";
	}


	@RequestMapping(value="/vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementService.findById(id);
	}


	@RequestMapping(value="/vehicleMovements/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {

		vehicleMovementService.save(vehicleMovement);

		return "redirect:/vehicleMovements";
	}

	@RequestMapping(value="/vehicleMovements/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleMovementService.delete(id);

		return "redirect:/vehicleMovements";
	}

	/*@RequestMapping(value="/vehicleMovements", method=RequestMethod.GET)
	public String getVehicleModel() {
		return "vehicle_movement";
	}*/
}
