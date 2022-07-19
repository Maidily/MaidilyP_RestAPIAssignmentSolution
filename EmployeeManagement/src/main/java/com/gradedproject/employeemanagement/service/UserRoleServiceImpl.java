package com.gradedproject.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradedproject.employeemanagement.entity.Role;
import com.gradedproject.employeemanagement.entity.User;
import com.gradedproject.employeemanagement.repository.RoleRepository;
import com.gradedproject.employeemanagement.repository.UserRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	@Override
	public String addUser(User user) {
		
		// save new user details
		userRepository.saveAndFlush(user);
		return "User added successfully";
	}
	
	
	@Override
	public String addRole(Role role) {
		
		// save new role details
		roleRepository.saveAndFlush(role);
		return "Role added successfully";
	}
	
	

}
