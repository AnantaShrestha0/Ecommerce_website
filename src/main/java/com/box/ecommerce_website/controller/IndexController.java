package com.box.ecommerce_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/shop")
	public String getShop() {
		
		return "shop";
	}
	
	@GetMapping("/aboutus")
	public String getAboutUs() {
		return "about-us";
	}
	
	@GetMapping("/contactus")
	public String getContactUs() {
		return "contact";
	}
	
	
}
