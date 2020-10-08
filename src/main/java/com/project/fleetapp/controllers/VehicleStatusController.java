package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;

	@RequestMapping(value="/vehicleStatuses", method=RequestMethod.GET)
	public String getVehicleStatuses(Model model) {

		List<VehicleStatus> vehicleStatusList= vehicleStatusService.getVehicleStatuses();

		model.addAttribute("vehicleStatuses", vehicleStatusList);

		return "vehicleStatus";
	}


	@RequestMapping(value = "/vehicleStatuses/addNew", method = RequestMethod.POST)
	public String addNew(VehicleStatus vehicleStatus) {

		vehicleStatusService.save(vehicleStatus);

		return "redirect:/vehicleStatuses";
	}


	@RequestMapping(value="/vehicleStatuses/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusService.findById(id);
	}


	@RequestMapping(value="/vehicleStatuses/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {

		vehicleStatusService.save(vehicleStatus);

		return "redirect:/vehicleStatuses";
	}

	@RequestMapping(value="/vehicleStatuses/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleStatusService.delete(id);

		return "redirect:/vehicleStatuses";
	}
	
	/*@RequestMapping(value="/vehicleStatuses", method=RequestMethod.GET)
	public String getVehicleStatus() {
		return "vehicle_status";
	}*/
}
