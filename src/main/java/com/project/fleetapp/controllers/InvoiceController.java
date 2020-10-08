package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.Invoice;
import com.project.fleetapp.services.ClientService;
import com.project.fleetapp.services.InvoiceService;
import com.project.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@RequestMapping(value="/invoices", method=RequestMethod.GET)
	public String getInvoices(Model model) {

		model.addAttribute("invoices", invoiceService.getInvoices());


		model.addAttribute("clients", clientService.getClients());

		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());
		return "invoice";
	}


	@RequestMapping(value = "/invoices/addNew", method = RequestMethod.POST)
	public String addNew(Invoice invoice) {

		invoiceService.save(invoice);

		return "redirect:/invoices";
	}


	@RequestMapping(value="/invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {
		return invoiceService.findById(id);
	}


	@RequestMapping(value="/invoices/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {

		invoiceService.save(invoice);

		return "redirect:/invoices";
	}

	@RequestMapping(value="/invoices/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {

		invoiceService.delete(id);

		return "redirect:/invoices";
	}
	
	/*@RequestMapping(value="/invoices", method=RequestMethod.GET)
	public String getEmployeeType() {
		return "invoice";
	}*/
}
