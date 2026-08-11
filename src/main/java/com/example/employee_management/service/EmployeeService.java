package com.example.employee_management.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.example.employee_management.entity.Employee;

import com.example.employee_management.repository.EmployeeRepository;

import com.example.employee_management.exception.EmployeeNotFoundException;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

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

        Employee saved = employeeRepository.save(employee);

        logger.info("Added employee: {}", saved.getId());

        return saved;
    }

    public Employee updateEmployee(Long id, Employee employee) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found"));

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());

        Employee updated = employeeRepository.save(existing);

        logger.info("Updated employee: {}", id);

        return updated;
    }

    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

        logger.info("Deleted employee: {}", id);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Khong tim thay employee"));
    }

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeService.class);


}