package com.box.ecommerce_website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.box.ecommerce_website.model.ProductModel;
import com.box.ecommerce_website.repo.ProductRepo;
import com.box.ecommerce_website.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public void addProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		productRepo.save(productModel);
	}

	@Override
	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

}
