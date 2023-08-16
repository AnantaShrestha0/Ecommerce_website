package com.box.ecommerce_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.ecommerce_website.model.UserModel;
import com.box.ecommerce_website.service.CartService;
import com.box.ecommerce_website.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired 
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/addToCart")
	public String getAddToCart(@RequestParam int id,HttpSession httpSession) {
		UserModel user=(UserModel) httpSession.getAttribute("validUser");
		if(user==null){
			return "redirect:/user/signin";
		}
		int uid=user.getId();
		cartService.addCart(uid,id);
		int c=user.getCartitems();
		user.setCartitems((c+1));
		userService.addUser(user);
		
		return "redirect:/userHomepage";
	}
	
	
	@GetMapping("/deleteCart")
	public String getDeleteCart(@RequestParam int id,HttpSession httpSession) {
		UserModel user=(UserModel) httpSession.getAttribute("validUser");
		if(user==null){
			return "redirect:/user/signin";
		}
		int c=user.getCartitems();
		user.setCartitems((c-1));
		cartService.deleteCart(id);
		return "redirect:/userHomepage";
	}
	
	

	

	
}
