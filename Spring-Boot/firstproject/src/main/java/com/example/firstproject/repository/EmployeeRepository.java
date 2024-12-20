package com.example.firstproject.repository;

import com.example.firstproject.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    ArrayList<Employee> findAll();
}
