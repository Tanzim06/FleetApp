package com.project.fleetapp.services;

import com.project.fleetapp.models.VehicleHire;
import com.project.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;


    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }


    public void save(VehicleHire vehicleHires) {
        vehicleHireRepository.save(vehicleHires);
    }

    public Optional<VehicleHire> findById(int id) {
        return vehicleHireRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
