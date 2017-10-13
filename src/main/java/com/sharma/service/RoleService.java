package com.sharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.dao.RoleDao;
import com.sharma.model.UserRole;

@Service("roleService")
public class RoleService {
	
	@Autowired
	RoleDao roleDao;
	
	public List getAllRole(){
		
		return roleDao.getAll();
	}
	
	public UserRole getRole(String role){
		return roleDao.getRole(role);
	}

}
