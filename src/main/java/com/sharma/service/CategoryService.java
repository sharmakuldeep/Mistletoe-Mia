package com.sharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharma.dao.CategoryDao;
import com.sharma.model.Category;
@Service("categoryService")
public class CategoryService {
	
	@Autowired
	 CategoryDao categoryDao;
	
	public Category get(int categoryId){
		return categoryDao.get(categoryId);
	};
	public List<Category> list(){
		System.out.println("in category service");
		return categoryDao.list();
	};	
	public boolean add(Category category){
		
		return categoryDao.add(category);
	};
	boolean update(Category category){
		return categoryDao.update(category);
	};
	boolean delete(Category category){
		return categoryDao.delete(category);
	};

	List<Category> getCategoryByParam(String param, int count){
		
		return categoryDao.getCategoryByParam(param, count);
	};	
	
	
	// business methods
	List<Category> listActiveCategories(){
		return categoryDao.listActiveCategories();
	};

}
