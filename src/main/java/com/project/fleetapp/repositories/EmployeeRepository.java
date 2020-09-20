package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fleetapp.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
