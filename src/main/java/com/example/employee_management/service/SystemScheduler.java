package com.example.employee_management.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SystemScheduler {

    @Scheduled(fixedRate = 30000)
    public void systemRunning() {
        System.out.println("System running");
    }
}