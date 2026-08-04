package com.example.employee_management.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.example.employee_management.entity.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee("EMP-001", "Do"));
        employees.add(new Employee("EMP-002", "Tran"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}