package com.project.fleetapp.services;

import com.project.fleetapp.models.Employee;
import com.project.fleetapp.models.Employee;
import com.project.fleetapp.models.User;
import com.project.fleetapp.repositories.EmployeeRepository;
import com.project.fleetapp.repositories.EmployeeRepository;
import com.project.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);

    }

    public Employee findByUsername(String username) {
       return employeeRepository.findByUsername(username);
    }

    public void assignUsername(int id){
        Employee employee= employeeRepository.findById(id).orElse(null);
        User user= userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname());
                employee.setUsername(user.getUsername());
                employeeRepository.save(employee);
    }
}
