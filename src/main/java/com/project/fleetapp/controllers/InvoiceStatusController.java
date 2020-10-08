package com.project.fleetapp.controllers;

import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.models.State;
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
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@RequestMapping(value="/invoiceStatuses", method=RequestMethod.GET)
	public String getInvoiceStatuses(Model model) {


		List<InvoiceStatus> invoiceStatusList= invoiceStatusService.getInvoiceStatuses();

		model.addAttribute("invoiceStatuses", invoiceStatusList);

		return "invoiceStatus";
	}


	@RequestMapping(value = "/invoiceStatuses/addNew", method = RequestMethod.POST)
	public String addNew(InvoiceStatus invoiceStatus) {

		invoiceStatusService.save(invoiceStatus);

		return "redirect:/invoiceStatuses";
	}


	@RequestMapping(value="/invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusService.findById(id);
	}


	@RequestMapping(value="/invoiceStatuses/update", method ={RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {

		invoiceStatusService.save(invoiceStatus);

		return "redirect:/invoiceStatuses";
	}

	@RequestMapping(value="/invoiceStatuses/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
	public String update(Integer id) {

		invoiceStatusService.delete(id);

		return "redirect:/invoiceStatuses";
	}

	/*@RequestMapping(value="/invoice_status", method=RequestMethod.GET)
	public String getInvoiceStatus() {
		return "invoice_status";
	}*/
}
