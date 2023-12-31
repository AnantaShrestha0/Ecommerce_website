package com.box.ecommerce_website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.ecommerce_website.model.ProductModel;
import com.box.ecommerce_website.repo.ProductRepo;
import com.box.ecommerce_website.service.ProductService;

@Service
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

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		
		productRepo.deleteById(id);
		
	}

	@Override
	public ProductModel getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public ProductModel findById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

}
