package com.example.employee_management.controller;
import org.springframework.http.ResponseEntity;
import jakarta.validation.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.example.employee_management.service.EmployeeService;
import com.example.employee_management.entity.Employee;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(
            @Valid @RequestBody Employee employee,
            BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(result.getAllErrors());
        }

        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping("/search")
    public List<Employee> search(
            @RequestParam String name) {

        return employeeService.searchByName(name);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
}