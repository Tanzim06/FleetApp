package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.VehicleModel;
import com.project.fleetapp.models.State;
import com.project.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;

	@RequestMapping(value="/vehicleModels", method=RequestMethod.GET)
	public String getVehicleModels(Model model) {

		List<VehicleModel> vehicleModelList= vehicleModelService.getVehicleModels();

		model.addAttribute("vehicleModels", vehicleModelList);

		return "vehicleModel";
	}


	@RequestMapping(value = "/vehicleModels/addNew", method = RequestMethod.POST)
	public String addNew(VehicleModel vehicleModel) {

		vehicleModelService.save(vehicleModel);

		return "redirect:/vehicleModels";
	}


	@RequestMapping(value="/vehicleModels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);
	}


	@RequestMapping(value="/vehicleModels/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {

		vehicleModelService.save(vehicleModel);

		return "redirect:/vehicleModels";
	}

	@RequestMapping(value="/vehicleModels/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		vehicleModelService.delete(id);

		return "redirect:/vehicleModels";
	}

	/*@RequestMapping(value="/vehicle_model", method=RequestMethod.GET)
	public String getVehicleModel() {
		return "vehicle_model";
	}*/
}
