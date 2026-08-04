package com.example.employee_management.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UtilityService {

    private final Random random;

    public UtilityService(Random random) {
        this.random = random;
    }

    public String generateEmployeeCode() {
        return "EMP-" + random.nextInt(1000);
    }

}