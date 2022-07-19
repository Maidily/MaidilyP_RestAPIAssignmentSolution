package com.gradedproject.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradedproject.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
