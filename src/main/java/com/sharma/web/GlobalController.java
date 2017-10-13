package com.sharma.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sharma.model.User;
import com.sharma.service.UserService;

@ControllerAdvice
public class GlobalController {
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	private User userModel = null;
	private User user = null;	
	
	
	@ModelAttribute("userModel")
	public User getUserModel() {		
		if(session.getAttribute("userModel")==null) {		
			System.out.println("userModel is not null");
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			if(!authentication.getPrincipal().equals("anonymousUser")){
				// get the user from the database
				user = userService.getByUserName(authentication.getName());
				
				if(user!=null) {
					// create a new model
					userModel = new User();
					// set the name and the id
//					userModel.setId(user.getId());
//					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
					userModel.setUsername(user.getUsername());
					userModel.setRoleName(user.getUsername());
//					userModel.setRoleName((user.getUserRole().);					
//					if(user.getRole().equals("USER")) {
//						userModel.setCart(user.getCart());					
//					}				
	
					session.setAttribute("userModel", userModel);
					return userModel;
				}			
			}
		}
		System.out.println("userModel is null");
		return (User) session.getAttribute("userModel");		
	}
		

}
