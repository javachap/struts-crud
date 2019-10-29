package com.javachap.service.impl;

import java.util.List;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.domain.impl.CategoryImpl;
import com.javachap.domain.impl.LeadImpl;
import com.javachap.domain.impl.UserImpl;
import com.javachap.service.CategoryService;
import com.javachap.service.LeadService;
import com.javachap.service.ServiceUtils;
import com.javachap.service.UserService;

public class Test {
	
	public static void main(String args[]) {
		
		UserService userService = ServiceUtils.getUserService();
		// User Authenticate
		User user =  userService.authenticate("user@javachap.com", "javachap");
		System.out.println("User:" + user);
		
		// User Save
		user = new UserImpl();
		user.setFirstName("java");
		user.setLastName("chap");
		user.setEmail("email"+System.currentTimeMillis());
		user.setPassword("test");
		userService.save(user);
		
		// User Get
		user = userService.getUser(user.getId());
		System.out.println("User:" + user);

		
		CategoryService categoryService = ServiceUtils.getCategoryService();
		
		// Category Save
		Category category = new CategoryImpl();
		category.setName("Test Name_" + System.currentTimeMillis());
		category.setDescription("Test Description");
		categoryService.save(category);
		
		category = categoryService.getCategory("IT Services");
		System.out.println(category);
		
		List<Category> categories = categoryService.getAllCategories();
		System.out.println(categories);
		
		category = categoryService.getCategory(category.getId());
		System.out.println(category);
		
		LeadService leadService = ServiceUtils.getLeadService();
		Lead lead = new LeadImpl();
		lead.setTitle("Test Title");
		lead.setDescription("Test Description");
		lead.setFirstName("Test");
		lead.setLastName("test");
		lead.setEmail("test");
		lead.setPhone("12333");
		lead.setPrice(10.2f);
		lead.setStatus(Lead.Status.Published.toString());
		lead.setCategory(category);
		lead.setOwner(user);
		leadService.save(lead);
		
		lead = leadService.getLead(lead.getId());
		System.out.println(lead);		
	}
}
