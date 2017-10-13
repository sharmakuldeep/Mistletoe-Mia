package com.sharma.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.RoleDao;
import com.sharma.model.UserRole;
@Repository("roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAll() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM UserRole")
						.list();
	}
	
	public UserRole getRole(String role){
		
		List l = sessionFactory.
				getCurrentSession().
				createQuery("From UserRole where role=?")
				.setParameter(0, role).list();
		return (UserRole) l.get(0);
	}

}
