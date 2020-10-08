package com.project.fleetapp.controllers;

import com.project.fleetapp.models.VehicleHire;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.LocationService;
import com.project.fleetapp.services.VehicleHireService;
import com.project.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ClientService clientService;

	@RequestMapping(value="/vehicleHires", method=RequestMethod.GET)
	public String getVehicleHires(Model model) {


		model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("clients", clientService.getClients());

		return "vehicleHire";
	}


	@RequestMapping(value = "/vehicleHires/addNew", method = RequestMethod.POST)
	public String addNew(VehicleHire vehicleHires) {

		vehicleHireService.save(vehicleHires);

		return "redirect:/vehicleHires";
	}


	@RequestMapping(value="/vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireService.findById(id);
	}


	@RequestMapping(value="/vehicleHires/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHires) {

		vehicleHireService.save(vehicleHires);

		return "redirect:/vehicleHires";
	}

	@RequestMapping(value="/vehicleHires/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleHireService.delete(id);

		return "redirect:/vehicleHires";
	}
	
	/*@RequestMapping(value="/vehicleHires", method=RequestMethod.GET)
	public String getVehicleHire() {
		return "vehicleHires";
	}*/
}
