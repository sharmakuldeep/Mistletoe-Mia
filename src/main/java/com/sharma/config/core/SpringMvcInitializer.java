package com.sharma.config.core;


import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sharma.config.AppConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}	
	
	//this code is for throwing exception if page is not found
	//Exception will be catched in GlobalDefaultException File.
//	@Override
//	protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
//	    final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
//	    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
//	    return dispatcherServlet;
//	}
	
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	 @Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//	        registration.setMultipartConfig(getMultipartConfigElement());
		    //registration.setMultipartConfig(new MultipartConfigElement("/home/kuldeep/Desktop/Spring/Spring-Security/MistletoeMia/src/main/webapp/assets/images/"));
		// upload temp file will put here
//	        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
	        File uploadDirectory = new File("/home/kuldeep/Downloads/MisTemp/");
	        
	        System.out.println("config"+uploadDirectory.getAbsolutePath());
	     // register a MultipartConfigElement
	        MultipartConfigElement multipartConfigElement =
	                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
	                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

	        registration.setMultipartConfig(multipartConfigElement);
	    }
	 
	    private MultipartConfigElement getMultipartConfigElement() {
	        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
	        return multipartConfigElement;
	    }
	 
	    private static final String LOCATION = ""; // Temporary location where files will be stored
	 
	    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
	                                                        // Beyond that size spring will throw exception.
	    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
	     
	    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk 

	

	
}