package com.gradedproject.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradedproject.employeemanagement.entity.Role;
import com.gradedproject.employeemanagement.service.UserRoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	UserRoleService roleService;
	
	
	
	// add POST mapping for "/roles/add" :: add new role for authentication
	@PostMapping("/add")
	public String addRole(@RequestBody Role role) {
		
		return roleService.addRole(role);
	}

}
