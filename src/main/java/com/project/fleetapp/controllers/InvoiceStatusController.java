package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InvoiceStatusController {

	@RequestMapping(value="/invoice_status", method=RequestMethod.GET)
	public String getInvoiceStatus() {
		return "invoice_status";
	}
}
