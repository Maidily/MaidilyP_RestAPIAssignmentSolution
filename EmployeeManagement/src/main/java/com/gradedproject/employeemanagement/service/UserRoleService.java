package com.gradedproject.employeemanagement.service;

import com.gradedproject.employeemanagement.entity.Role;
import com.gradedproject.employeemanagement.entity.User;

public interface UserRoleService {

	String addUser(User user);

	String addRole(Role role);

}
