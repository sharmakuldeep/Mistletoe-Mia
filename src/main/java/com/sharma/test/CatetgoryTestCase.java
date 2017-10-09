package com.sharma.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sharma.model.Category;
import com.sharma.service.CategoryService;


public class CatetgoryTestCase {

		
		private static AnnotationConfigApplicationContext context=null;		
		private static CategoryService categoryService;	
		
		@BeforeClass
		public static void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.sharma");
			context.refresh();
			categoryService = (CategoryService)context.getBean("categoryService");
		}
			
		@Test
		public void testAddCategory(){	
				Category ctg = new Category();
				ctg.setCategoryName("Skirt");
				assertEquals("Save new category", true, categoryService.add(ctg));
	    }

}
