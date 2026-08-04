package com.example.employee_management.entity;

public class Employee {

    private String employeeCode;
    private String name;

    public Employee() {
    }

    public Employee(String employeeCode, String name) {
        this.employeeCode = employeeCode;
        this.name = name;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}