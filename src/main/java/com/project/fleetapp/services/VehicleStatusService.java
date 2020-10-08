package com.project.fleetapp.services;

import com.project.fleetapp.models.VehicleStatus;
import com.project.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;


    public List<VehicleStatus> getVehicleStatuses(){
        return vehicleStatusRepository.findAll();
    }


    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
