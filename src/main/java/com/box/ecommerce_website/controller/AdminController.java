package com.box.ecommerce_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.box.ecommerce_website.model.AdminModel;
import com.box.ecommerce_website.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/signin")
	public String getAdminSignin() {
		return "admin-signin";
	}
	
	
	@GetMapping("/forgotpassword")
	public String getForgotPassword() {
		return "admin-forgot-password";
	}
	
	@PostMapping("/signin")
	public String postAdminSignin(AdminModel adminModel,Model model,HttpSession httpSession) {
		String email=adminModel.getEmail();
		String password=adminModel.getPassword();
		
		AdminModel admin=adminService.findAdmin(email, password);
		if(admin==null) {
			model.addAttribute("Error", "Email and password not matched");
			return "admin-signin";
		}
		
		
		try {
			
			if(admin.getChangedEmailAndPassword().equals("yes")) {
				httpSession.setAttribute("validAdmin", admin);
				return "redirect:/adminHomePage";
			}
			
		
		
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("adminObj",admin);
			return "admin-change-email-password";
		}
		
		model.addAttribute("adminObj",admin);
		return "admin-change-email-password";
	}
	
	
	@PostMapping("/changeEmailAndPassword")
	public String postChangeEmailAndPassword(AdminModel adminModel,Model model) {
		
		String password=adminModel.getPassword();
		String confirmPassword=adminModel.getConfirmPassword();
		if(password.equals(confirmPassword)) {
			adminModel.setChangedEmailAndPassword("yes");
			adminService.addAdmin(adminModel);
			return "redirect:/adminHomePage";
		}
		model.addAttribute("Error", "Password not matched");
		return "admin-change-email-password";
	}
	
	
	
	
	
	
	
	
	
	
	
}
