package com.sharma.test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sharma.config.AppConfig;
import com.sharma.model.User;
import com.sharma.model.UserRole;
import com.sharma.service.RoleService;
import com.sharma.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class UserTestCase {
	
	
	private static AnnotationConfigApplicationContext context=null;		
	private static UserService userService;	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sharma");
		context.refresh();
		userService = (UserService)context.getBean("userService");
	}
		
	@Test
	public void testAddCategory(){
//		   RoleService roleService = (RoleService)context.getBean("roleService");
//		    List <UserRole> lst = (List)roleService.getAllRole();
//		    Set<UserRole> set = new HashSet<UserRole>(lst);
			User user = new User();
			   Set<UserRole> roleSet= new HashSet<UserRole>();
			   roleSet.add(new UserRole(user,"ROLE_ADMIN"));
//			   roleSet.add(new UserRole(user,"ROLE_USER"));
			user.setEnabled(true);
			user.setUsername("Nirmal");
			user.setPassword("123456");
			String password = user.getPassword();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			user.setPassword(hashedPassword);
			user.setUserRole(roleSet);
			assertEquals("Save new category", true, userService.register(user));
			
    }

}
