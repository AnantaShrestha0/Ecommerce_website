package com.box.ecommerce_website.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.ecommerce_website.model.CategoryModel;

public interface CategoryRepo extends JpaRepository<CategoryModel, Integer>{

}
