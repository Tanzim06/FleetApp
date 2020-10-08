package com.project.fleetapp.services;

import com.project.fleetapp.models.VehicleMovement;
import com.project.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;


    public List<VehicleMovement> getVehicleMovements() {
        return vehicleMovementRepository.findAll();
    }


    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);

    }
}
