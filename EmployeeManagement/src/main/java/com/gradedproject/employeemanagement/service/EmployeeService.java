package com.gradedproject.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.gradedproject.employeemanagement.entity.Employee;

public interface EmployeeService {

	String saveSingleEmployee(Employee employee);
	
	String saveAllEmployees(List<Employee> employees);
	
	List<Employee> fetchAllEmployees();

	Optional<Employee> fetchEmployeeById(Long id);

	Employee updateEmployeeById(Employee employee);

	String deleteEmployeeById(Long id);

	List<Employee> fetchEmployeeSortedByIdWithThisFirstName(String firstName);

	List<Employee> fetchEmployeeCustomSortedByFirstName(Direction direction);

	

}
