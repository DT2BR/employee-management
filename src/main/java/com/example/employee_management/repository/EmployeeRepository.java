package com.example.employee_management.repository;

import com.example.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    @Query("""
        SELECT e.department.name, COUNT(e)
        FROM Employee e
        GROUP BY e.department.name
    """)
    List<Object[]> countEmployeesByDepartment();
}