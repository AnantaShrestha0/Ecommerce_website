package com.box.ecommerce_website.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.ecommerce_website.model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Integer>{

}
