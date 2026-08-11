package com.example.employee_management.controller;

import com.example.employee_management.entity.User;
import com.example.employee_management.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        return ResponseEntity.ok(
                userService.register(user)
        );
    }
}