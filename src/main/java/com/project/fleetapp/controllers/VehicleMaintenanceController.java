package com.project.fleetapp.controllers;

import com.project.fleetapp.models.VehicleMaintenance;
import com.project.fleetapp.services.SupplierService;
import com.project.fleetapp.services.VehicleMaintenanceService;
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
public class VehicleMaintenanceController {

	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value="/vehicleMaintenances", method=RequestMethod.GET)
	public String getVehicleMaintenances(Model model) {

		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSuppliers());

		return "vehicleMaintenance";
	}


	@RequestMapping(value = "/vehicleMaintenances/addNew", method = RequestMethod.POST)
	public String addNew(VehicleMaintenance vehicleMaintenance) {

		vehicleMaintenanceService.save(vehicleMaintenance);

		return "redirect:/vehicleMaintenances";
	}


	@RequestMapping(value="/vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceService.findById(id);
	}


	@RequestMapping(value="/vehicleMaintenances/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {

		vehicleMaintenanceService.save(vehicleMaintenance);

		return "redirect:/vehicleMaintenances";
	}

	@RequestMapping(value="/vehicleMaintenances/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleMaintenanceService.delete(id);

		return "redirect:/vehicleMaintenances";
	}
	
	
	/*@RequestMapping(value="/vehicleMaintenances", method=RequestMethod.GET)
	public String getVehicleManagement() {
		return "vehicle_maintenance";
	}*/
}
