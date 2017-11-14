package com.sharma.dao;

import java.util.List;

import com.sharma.model.Role;

public interface RoleDao {
	
	
	public List<Role>getAll();
	public Role getRole(String role);

}
