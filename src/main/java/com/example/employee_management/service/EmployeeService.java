package com.example.employee_management.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.example.employee_management.entity.Employee;

import com.example.employee_management.repository.EmployeeRepository;

import com.example.employee_management.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Khong tim thay employee"));
    }
}