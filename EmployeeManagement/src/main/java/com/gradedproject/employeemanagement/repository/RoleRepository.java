package com.gradedproject.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradedproject.employeemanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
