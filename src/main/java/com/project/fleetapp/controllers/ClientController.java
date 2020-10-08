package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.Client;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public String getClients(Model model) {

		//List<Client> clientList= clientService.getClients();
		model.addAttribute("clients", clientService.getClients());

		//List<Country> countryList= countryService.getCountries();

		model.addAttribute("countries", countryService.getCountries());

		model.addAttribute("states", stateService.getStates());
		return "client";
	}


	@RequestMapping(value = "/clients/addNew", method = RequestMethod.POST)
	public String addNew(Client client) {

		clientService.save(client);

		return "redirect:/clients";
	}


	@RequestMapping(value="/clients/findById")
	@ResponseBody
	public Optional<Client> findById(int id) {
		return clientService.findById(id);
	}


	@RequestMapping(value="/clients/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {

		clientService.save(client);

		return "redirect:/clients";
	}

	@RequestMapping(value="/clients/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {

		clientService.delete(id);

		return "redirect:/clients";
	}
	
	
	/*@RequestMapping(value="/clients", method=RequestMethod.GET)
	public String getClient() {
		return "client";
	}*/
}
