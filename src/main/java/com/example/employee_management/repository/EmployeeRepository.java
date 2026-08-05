package com.example.employee_management.repository;
import com.example.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContaining(String name);
}