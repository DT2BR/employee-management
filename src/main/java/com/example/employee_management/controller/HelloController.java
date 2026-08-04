package com.example.employee_management.controller;

import com.example.employee_management.service.UtilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final UtilityService utilityService;

    public HelloController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello "+ utilityService.generateEmployeeCode();
    }
}