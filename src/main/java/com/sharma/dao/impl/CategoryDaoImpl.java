package com.sharma.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.CategoryDao;
import com.sharma.model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category get(int categoryId) {
		// TODO Auto-generated method stub
		try {			
			return (Category) sessionFactory
					.getCurrentSession()
						.get(Category.class,Integer.valueOf(categoryId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return 	(List<Category>) sessionFactory
				.getCurrentSession()
				.createQuery("FROM Category").list();
				
	}

	@Override
	public boolean add(Category category) {
		try {			
			 sessionFactory
					.getCurrentSession()
					 .persist(category);
			 return true; 
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> getCategoryByParam(String param, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> listActiveCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
