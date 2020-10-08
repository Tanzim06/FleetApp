package com.project.fleetapp.services;

import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;


    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }


    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> findById(int id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
