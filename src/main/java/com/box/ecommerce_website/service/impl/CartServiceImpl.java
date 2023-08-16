package com.box.ecommerce_website.service.impl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.ecommerce_website.model.CartModel;
import com.box.ecommerce_website.model.ProductModel;
import com.box.ecommerce_website.model.UserModel;
import com.box.ecommerce_website.repo.CartRepo;
import com.box.ecommerce_website.service.CartService;
import com.box.ecommerce_website.service.ProductService;
import com.box.ecommerce_website.service.UserService;


@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public void addCart(int userId, int productId) {
		// TODO Auto-generated method stub
	
		ProductModel product=productService.findById(productId);
		CartModel cart=new CartModel();
		cart.setUserId(userId);
		cart.setProductModel(product);
		cart.setQuantity(1);
		cart.setSubtotal(product.getCurrentPrice());
		cartRepo.save(cart);
	}

	@Override
	public List<CartModel> getAllCart() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub
		cartRepo.deleteById(id);
	}

	
}
