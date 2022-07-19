package com.gradedproject.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradedproject.employeemanagement.entity.User;
import com.gradedproject.employeemanagement.service.UserRoleService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRoleService userService;
	
	
	
	// add POST mapping for "/users/add" :: add new user data for authentication
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}

}
