package com.box.ecommerce_website.service;

import java.util.List;

import com.box.ecommerce_website.model.CartModel;

public interface CartService {

	void addCart(int userId,int productId);
	List<CartModel> getAllCart();
	void deleteCart(int id);
}
