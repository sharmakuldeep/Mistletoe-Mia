package com.sharma.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sharma.model.Category;
import com.sharma.model.Product;
import com.sharma.service.CategoryService;
import com.sharma.service.ProductService;
import com.sharma.util.FileUtil;
import com.sharma.validator.ProductValidator;

@Controller
public class DataFillerController {

	@Autowired
	 CategoryService categoryService;
	@Autowired
	 ProductService productService;
	
	@RequestMapping(value={"/manage/product"}, method= RequestMethod.GET)
	  public ModelAndView addProduct(@RequestParam(name="success",required=false)String success){	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base");
		mv.addObject("product", new Product());
		mv.addObject("category", new Category());
		mv.addObject("title", "Add Product");
		mv.addObject("userClickManageProduct", true);
		System.out.println("Hello KUldeep");
		if(success != null) {
			if(success.equals("product")){
				mv.addObject("message", "Product submitted successfully!");
			}	
			else if (success.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value={"/manage/{id}/product"}, method= RequestMethod.GET)
	  public ModelAndView manageProduct(@PathVariable("id")int id){	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("base");
		mv.addObject("product", productService.get(id));
		mv.addObject("category", new Category());
		mv.addObject("title", "Add Product");
		mv.addObject("userClickManageProduct", true);		
		return mv;
	}
	
	//uploading product******************
		@RequestMapping(value = "/addProduct", method=RequestMethod.POST)
		public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, 
				BindingResult results, Model model, HttpServletRequest request) {
			
			System.out.println("Hello Product welcome");
			
			// mandatory file upload check
			if(mProduct.getId() == 0) {
				new ProductValidator().validate(mProduct, results);
			}
			else {
				// edit check only when the file has been selected
				if(!mProduct.getFile().getOriginalFilename().equals("")) {
					new ProductValidator().validate(mProduct, results);
				}			
			}
			
			if(results.hasErrors()) {
				model.addAttribute("message", "Validation fails for adding the product!");
				model.addAttribute("userClickManageProduct",true);
				return "page";
			}			
			if(mProduct.getId() == 0 ) {
				productService.add(mProduct);
			}
			else {
				productService.update(mProduct);
			}			
			System.out.println(mProduct.getFile().getOriginalFilename());
			
			 //upload the file
			 if(!mProduct.getFile().getOriginalFilename().equals("") ){
				FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode()); 
			 }
			 if(!mProduct.getFile1().getOriginalFilename().equals("") ){
					FileUtil.uploadFile(request, mProduct.getFile1(), mProduct.getCode()+"_"+1); 
				 }
			 if(!mProduct.getFile2().getOriginalFilename().equals("") ){
					FileUtil.uploadFile(request, mProduct.getFile2(), mProduct.getCode()+"_"+2); 
				 }
			 if(!mProduct.getFile3().getOriginalFilename().equals("") ){
					FileUtil.uploadFile(request, mProduct.getFile3(), mProduct.getCode()+"_"+3); 
				 }
			 return "redirect:/manage/product?success=product";	
		}	
	
	@RequestMapping(value={"/manage/category"}, method= RequestMethod.POST)
	  public String addCategory(@ModelAttribute("category") Category mCategory, 
			  HttpServletRequest request){	
		categoryService.add(mCategory);	
		System.out.println(request.getHeader("Referer"));
		return "redirect:" + request.getHeader("Referer") + "?success=category";
	}
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		System.out.println("getting category list");
		System.out.println(categoryService.list().size());
		return categoryService.list();
	}
	
	@ResponseBody
	@RequestMapping(value="/manage/product/{id}/activation")
	 public String  manageProductActivation(@PathVariable("id") int id){
		Product product = productService.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productService.update(product);		
		return (isActive)? "Product Dectivated Successfully!": "Product Activated Successfully";
	}
}
