package com.sharma.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sharma.exception.ProductNotFoundException;
import com.sharma.model.Category;
import com.sharma.model.Product;
import com.sharma.model.Role;
import com.sharma.model.User;
import com.sharma.service.CategoryService;
import com.sharma.service.EmailService;
import com.sharma.service.ProductService;
import com.sharma.service.RoleService;
import com.sharma.service.UserService;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	EmailService emailService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam(name="logout", required = false)	String logout) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("base");
		mv.addObject("title", "Home");
		mv.addObject("message", "MistletoeMia-Home");
		mv.addObject("userClickHome", true);
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Methods to load all the products and based on category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		System.out.println("in show all products");
		ModelAndView mv = new ModelAndView("base");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryService.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("base");

		// categoryDAO to fetch a single category
		Category category = null;

		category = categoryService.get(id);

		mv.addObject("title", category.getCategoryName());

		// passing the list of categories
		mv.addObject("categories", categoryService.list());

		// passing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	/*
	 * Viewing a single product
	 */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {

		ModelAndView mv = new ModelAndView("base");

		Product product = productService.get(id);

		if (product == null)
			throw new ProductNotFoundException();

		// update the view count
		product.setViews(product.getViews() + 1);
		productService.update(product);
		// ---------------------------

		mv.addObject("title", product.getName());
		mv.addObject("product", product);

		mv.addObject("userClickShowProduct", true);

		return mv;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout, 
			@RequestParam(name="activation", required = false) String activation) {
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("base");
		mv.addObject("title", "Login");
		mv.addObject("userClickLogin", true);
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		if(activation!=null) {
			mv.addObject("activation", "User activated successfully!");
		}
		return mv;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
		// Removes the authentication from securitycontext
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/?logout=true";
	}

	@RequestMapping(value = "/membership", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam(name="register", required=false) boolean register) {
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("roles", roleService.getAllRole());
		mv.addObject("user", new User());
		mv.setViewName("base");
		mv.addObject("title", "Register");
		mv.addObject("userClickRegister", true);
		if(register){
			mv.addObject("registered", "Registered Successfully");
			mv.addObject("activation", "An Activation Link is Send to your Mail.");
		}
		return mv;
	}

	@RequestMapping(value = "/membership", method = RequestMethod.POST)
	public String registerNew(@ModelAttribute("user") User user, HttpServletRequest request) {
		
		System.out.println("HEllO Kuldeeeeppppppppppppppppppppp");
		System.out.println(user.getRoleName());
		Role r = roleService.getRole(user.getRoleName());
	    //UserRole u = new UserRole();
	    //u.setRole(user.getRoleName());
	   // Set<UserRole> set = new HashSet<UserRole>();
	    Set<Role> set = new HashSet<Role>();
	    set.add(r);
	    user.setUserRole(set);
	    user.setEnabled(false);
		userService.register(user);
		emailService.sendEmail(user.getEmail(), 
				"skuldeep1989@gmail.com","Activation Link",
				"http://localhost:8080/MistletoeMia/activate/user/"+user.getUsername());
		return "redirect:/membership?register=true";		
	}

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		//System.out.println("getting category list");
		//System.out.println(categoryService.list().size());
		return categoryService.list();
	}
	
	@RequestMapping(value = "/403")
    public ModelAndView handleAccessDenied(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("base");
        mv.addObject("accessDenied", true);
        return mv;
    }
	
	
	@RequestMapping(value="/activate/user/{userName}")
	public String activateUserByEmail(@PathVariable("userName")String userName){
		 User u = userService.getByUserName(userName);
		 u.setEnabled(true);
		 userService.updateUser(u);
		 return "redirect:/login?activation=true";
	}
	

}
