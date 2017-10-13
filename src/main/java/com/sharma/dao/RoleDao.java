package com.sharma.dao;

import java.util.List;

import com.sharma.model.UserRole;

public interface RoleDao {
	
	
	public List<UserRole>getAll();
	public UserRole getRole(String role);

}
