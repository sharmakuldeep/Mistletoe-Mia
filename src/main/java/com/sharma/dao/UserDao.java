package com.sharma.dao;

import com.sharma.model.User;
import com.sharma.model.UserRole;

public interface UserDao {

	User findByUserName(String username);
	public void register(User user, UserRole role);
	

}