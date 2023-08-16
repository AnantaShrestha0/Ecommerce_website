package com.box.ecommerce_website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.box.ecommerce_website.model.CartModel;
import com.box.ecommerce_website.model.ProductModel;
import com.box.ecommerce_website.model.UserModel;
import com.box.ecommerce_website.service.CartService;
import com.box.ecommerce_website.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserPagecController {

	@Autowired
	private ProductService productService;
	 
	@Autowired
	private CartService cartService;
	
	@GetMapping("/userHomepage")
	public String getUserHomepage(Model model,HttpSession httpSession) {
		
		UserModel user=(UserModel) httpSession.getAttribute("validUser");
		if(user==null){
			return "redirect:/user/signin";
		}
		List<ProductModel> productList=productService.getAllProduct();
		List<CartModel> cartList=cartService.getAllCart();
		model.addAttribute("cartList", cartList);
		model.addAttribute("productList", productList);
		model.addAttribute("cartItems", user.getCartitems());
		return "user-homepage";
	}
	
	
	
	
	
}
