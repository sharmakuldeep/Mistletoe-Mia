package com.sharma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharma.model.Product;
import com.sharma.model.User;
import com.sharma.service.ProductService;
import com.sharma.service.UserService;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
    @Autowired
     ProductService productService;	
    @Autowired
    UserService userService;
    
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsList() {		
		return productService.list();				
	}
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		
		return productService.listActiveProducts();
				
	}
	@RequestMapping("/admin/all/users")
	@ResponseBody
	public List<User> getAllUsersList() {	
		//System.out.println("all users");
		return userService.getAllUser();				
	}
	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		
		return productService.listActiveProductsByCategory(id);
				
	}
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Product> getMostViewedProducts() {		
		return productService.getProductsByParam("views", 5);				
	}
		
	@RequestMapping("/mp/products")
	@ResponseBody
	public List<Product> getMostPurchasedProducts() {		
		return productService.getProductsByParam("purchases", 5);				
	}
}
