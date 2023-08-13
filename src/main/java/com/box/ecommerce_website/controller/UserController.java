package com.box.ecommerce_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/signin")
	public String getLogin() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "signup";
	}
	
	@GetMapping("/forgotpassword")
	public String getForgotPassword() {
		return "forgot-password";
	}
	
}
