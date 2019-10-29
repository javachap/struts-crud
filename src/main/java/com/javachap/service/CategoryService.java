package com.javachap.service;

import java.util.List;

import com.javachap.domain.Category;

public interface CategoryService extends Service {

	Category getCategory(Long categoryId);
	
	Category getCategory(String categoryName);
	
	Category save(Category category);
	
	List<Category> getAllCategories();
}
