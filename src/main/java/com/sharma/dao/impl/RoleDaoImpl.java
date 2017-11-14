package com.sharma.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.RoleDao;
import com.sharma.model.Role;
@Repository("roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Role")
						.list();
	}
	
	public Role getRole(String role){
		
		List l = sessionFactory.
				getCurrentSession().
				createQuery("From Role where roleName=?")
				.setParameter(0, role).list();
		return (Role) l.get(0);
	}

}
