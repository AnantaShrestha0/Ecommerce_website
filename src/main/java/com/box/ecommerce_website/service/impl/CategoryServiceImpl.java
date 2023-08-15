package com.box.ecommerce_website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.ecommerce_website.model.CategoryModel;
import com.box.ecommerce_website.repo.CategoryRepo;
import com.box.ecommerce_website.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public void addCategory(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		categoryRepo.save(categoryModel);
	}

	@Override
	public List<CategoryModel> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		categoryRepo.deleteById(id);
	}

	@Override
	public String findByIdName(int id) {
		// TODO Auto-generated method stub
		
		CategoryModel c=categoryRepo.findById(id).get();
		return c.getName();
	}

}
