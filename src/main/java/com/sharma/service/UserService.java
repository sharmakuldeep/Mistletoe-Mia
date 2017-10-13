package com.sharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.dao.UserDao;
import com.sharma.model.User;
import com.sharma.model.UserRole;

@Service("userService")
public class UserService {	
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user){
		
		userDao.register(user);
		return true;
		
	}
}
