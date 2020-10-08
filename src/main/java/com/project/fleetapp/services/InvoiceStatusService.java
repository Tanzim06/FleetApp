package com.project.fleetapp.services;

import com.project.fleetapp.models.InvoiceStatus;
import com.project.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;


    public List<InvoiceStatus> getInvoiceStatuses(){
        return invoiceStatusRepository.findAll();
    }


    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(int id) {
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
