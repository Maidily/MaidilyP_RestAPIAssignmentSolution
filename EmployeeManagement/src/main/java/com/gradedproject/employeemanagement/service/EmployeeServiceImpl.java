package com.gradedproject.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gradedproject.employeemanagement.entity.Employee;
import com.gradedproject.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	
	@Override
	public String saveSingleEmployee(Employee employee) {
		
		// save single employee details
		employeeRepository.saveAndFlush(employee);
		
		return "Employee saved successfully";
	}


	@Override
	public String saveAllEmployees(List<Employee> employees) {
		
		// save multiple employee details
		employeeRepository.saveAll(employees);
		employeeRepository.flush();
		
		return "All Employees saved successfully";
	}


	@Override
	public List<Employee> fetchAllEmployees() {
		
		// get all employee details from the database
		return employeeRepository.findAll();
	}


	@Override
	public Optional<Employee> fetchEmployeeById(Long id) {
		
		// get employee by id from database table
		return employeeRepository.findById(id);
	}


	@Override
	public Employee updateEmployeeById(Employee employee) {
		
		// update employee details in database using id
		if(employeeRepository.findById(employee.getId()).isPresent()) {
			
			Employee theEmployee = employeeRepository.findById(employee.getId()).get();
			
			theEmployee.setId(employee.getId());
			theEmployee.setFirstName(employee.getFirstName());
			theEmployee.setLastName(employee.getLastName());
			theEmployee.setEmail(employee.getEmail());
			
			employeeRepository.saveAndFlush(theEmployee);
			
			return theEmployee;
		}
		else {
			return null;
		}
	}


	@Override
	public String deleteEmployeeById(Long id) {
		
		// delete employee by id from database table
		employeeRepository.deleteById(id);
		
		return "Deleted employee id - " + id;
	}


	@Override
	public List<Employee> fetchEmployeeSortedByIdWithThisFirstName(String firstName) {

		// get employee records filtered by firstName from database
		Employee employeeWithFirstName = new Employee();
		employeeWithFirstName.setFirstName(firstName);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");

		Example<Employee> example = Example.of(employeeWithFirstName, exampleMatcher);

		return employeeRepository.findAll(example, Sort.by("id"));
	}


	@Override
	public List<Employee> fetchEmployeeCustomSortedByFirstName(Direction direction) {
		
		// get employee records sorted by firstName from database based on direction (ASC or DESC)
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
