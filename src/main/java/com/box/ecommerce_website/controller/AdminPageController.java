package com.box.ecommerce_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

	@GetMapping("/adminHomePage")
	public String getAdminHomePage() {
		return "admin-homepage";
	}
}
