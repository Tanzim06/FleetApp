package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.Contact;
import com.project.fleetapp.services.CountryService;
import com.project.fleetapp.services.ContactService;
import com.project.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;
	@Autowired private ContactService contactService;

	//Get All Contacts
	@GetMapping("/contacts")
	public String findAll(Model model){
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("contacts", contactService.findAll());
		return "contact";
	}

	@RequestMapping("contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(Integer id)
	{
		 Optional<Contact> o= contactService.findById(id);

		 return o;
	}

	//Add Contact
	@PostMapping(value="contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}

	
	/*@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String getContact() {
		return "contact";
	}*/
}
