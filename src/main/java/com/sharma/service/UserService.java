package com.sharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.dao.UserDao;
import com.sharma.model.User;

@Service("userService")
public class UserService {	
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user){		
		userDao.register(user);
		return true;		
	}
	
	public User getByUserName(String userName){
		return userDao.findByUserName(userName);
	}
	public boolean updateUser(User u){
		return userDao.updateUser(u);
		
	}
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	}
