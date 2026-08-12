package com.example.employee_management.controller;

import com.example.employee_management.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {

    private final EmployeeService employeeService;

    public StatisticsController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/statistics/count")
    public long countEmployees() {
        return employeeService.countEmployees();
    }

    @GetMapping("/employees/statistics/by-department")
    public List<Object[]> countByDepartment() {
        return employeeService.countEmployeesByDepartment();
    }
}