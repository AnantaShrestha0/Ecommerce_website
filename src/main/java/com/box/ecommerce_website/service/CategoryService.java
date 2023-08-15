package com.box.ecommerce_website.service;

import java.util.List;

import com.box.ecommerce_website.model.CategoryModel;

public interface CategoryService {

	
	
	
	void addCategory(CategoryModel categoryModel);
	void deleteCategory(int id);
	String findByIdName(int id);
	List<CategoryModel> getCategoryList();
	
	
}
