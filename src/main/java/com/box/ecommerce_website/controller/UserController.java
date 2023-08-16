package com.box.ecommerce_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.ecommerce_website.model.UserModel;
import com.box.ecommerce_website.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
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
	
	
	@PostMapping("/signin")
	public String postSignIn(UserModel userModel,Model model,HttpSession httpSession) {
		String username=userModel.getEmail();
		String password=userModel.getPassword();
		UserModel user=userService.findUser(username, password);
		if(user==null) {
			model.addAttribute("Error","username and password not found");
			return "signin";
		}
		httpSession.setAttribute("validUser", user);
        httpSession.setMaxInactiveInterval(-1);
		
		return "redirect:/userHomepage";
	}
	
	
	@PostMapping("/signup")
	public String postSignUp(UserModel userModel,Model model) {
		
		String password=userModel.getPassword();
		String conformPassword=userModel.getConfirmPassword();
		
		if(password.equals(conformPassword)) {
			
			UserModel user=userService.findUserByEmail(userModel.getEmail());
			if(user==null) {
				userService.addUser(userModel);
				return "signin";
			}
			model.addAttribute("Error","This email is already registered");
			return "signup";
			
		}
		
		
		model.addAttribute("Error","Password not matched");
		return "signup";
		
	}
	
	
	
	
	
	
	
	
}
