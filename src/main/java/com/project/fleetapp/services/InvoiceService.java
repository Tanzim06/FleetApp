package com.project.fleetapp.services;

import com.project.fleetapp.models.Invoice;
import com.project.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }


    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> findById(int id) {
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);

    }
}
