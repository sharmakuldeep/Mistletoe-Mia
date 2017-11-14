package com.sharma.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.UserDao;
import com.sharma.model.Cart;
import com.sharma.model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
				.createQuery("from User where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	public void register(User user){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		   Cart cart = new Cart();
		   cart.setUser(user);
		   user.setCart(cart);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		sessionFactory.getCurrentSession().persist(user);
	}
	
	public boolean updateUser(User u){
		sessionFactory.getCurrentSession().update(u);
		return true;
		
		
	}
	
	public List<User> getAllUser(){
		
		System.out.println("get All User DaoImpl()");
		return (List<User>) sessionFactory.getCurrentSession().createQuery("From User").list();
	}

}