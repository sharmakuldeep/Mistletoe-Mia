package com.sharma.dao;

import java.util.List;

import com.sharma.model.User;

public interface UserDao {

	User findByUserName(String username);
	public void register(User user);
	public boolean updateUser(User u);
	public List<User> getAllUser();

}