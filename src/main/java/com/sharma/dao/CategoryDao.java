package com.sharma.dao;

import java.util.List;

import com.sharma.model.Category;

public interface CategoryDao {
	

	Category get(int categoryId);
	List<Category> list();	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

	List<Category> getCategoryByParam(String param, int count);	
	
	
	// business methods
	List<Category> listActiveCategories();	

}
