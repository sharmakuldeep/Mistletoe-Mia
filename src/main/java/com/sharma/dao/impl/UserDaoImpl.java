package com.sharma.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.dao.UserDao;
import com.sharma.model.User;
import com.sharma.model.UserRole;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	public void register(User user, UserRole role){
		
		sessionFactory.getCurrentSession().persist(user);
		sessionFactory.getCurrentSession().persist(role);
	}

}