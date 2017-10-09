package com.sharma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.dao.ProductDAO;
import com.sharma.model.Product;

@Service("productService")
public class ProductService {
	
	@Autowired
	 ProductDAO productDao;
	public Product get(int productId){
		return productDao.get(productId);
	};
	public List<Product> list(){
		return productDao.list();
	};	
	public boolean add(Product product){
		return productDao.add(product);
	};
	public boolean update(Product product){
		return productDao.update(product);
	};
	public boolean delete(Product product){
		return productDao.delete(product);
	};

	public List<Product> getProductsByParam(String param, int count){
		return productDao.getProductsByParam(param, count);
	};	
	
	
	// business methods
	public List<Product> listActiveProducts(){
		return productDao.listActiveProducts();
	};	
	public List<Product> listActiveProductsByCategory(int categoryId){
		return productDao.listActiveProductsByCategory(categoryId);
	};
	public List<Product> getLatestActiveProducts(int count){
		return productDao.getLatestActiveProducts(count);
	};

}
