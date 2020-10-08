package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.services.SupplierService;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@RequestMapping(value="/suppliers", method=RequestMethod.GET)
	public String getSuppliers(Model model) {

		//List<Supplier> supplierList= supplierService.getSuppliers();
		model.addAttribute("suppliers", supplierService.getSuppliers());

		//List<Country> countryList= countryService.getCountries();

		model.addAttribute("countries", countryService.getCountries());

		model.addAttribute("states", stateService.getStates());
		return "supplier";
	}


	@RequestMapping(value = "/suppliers/addNew", method = RequestMethod.POST)
	public String addNew(Supplier supplier) {

		supplierService.save(supplier);

		return "redirect:/suppliers";
	}


	@RequestMapping(value="/suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {
		return supplierService.findById(id);
	}


	@RequestMapping(value="/suppliers/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {

		supplierService.save(supplier);

		return "redirect:/suppliers";
	}

	@RequestMapping(value="/suppliers/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {

		supplierService.delete(id);

		return "redirect:/suppliers";
	}
	
	
	/*@RequestMapping(value="/supplier", method=RequestMethod.GET)
	public String getSupplier() {
		return "supplier";
	}*/
}
