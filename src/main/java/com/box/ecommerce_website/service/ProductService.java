package com.box.ecommerce_website.service;

import java.util.List;

import com.box.ecommerce_website.model.ProductModel;

public interface ProductService {
  
	
	void addProduct(ProductModel productModel);
	void deleteProductById(int id);
	ProductModel getProductById(int id);
	List<ProductModel> getAllProduct();
}
