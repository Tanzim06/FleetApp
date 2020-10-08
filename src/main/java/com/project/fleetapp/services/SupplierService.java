package com.project.fleetapp.services;

import com.project.fleetapp.models.Supplier;
import com.project.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;


    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }


    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);

    }

}
