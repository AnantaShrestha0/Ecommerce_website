package com.box.ecommerce_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.ecommerce_website.model.SubscriberModel;
import com.box.ecommerce_website.service.SubscriberService;

@Controller
public class ContactController {

	@Autowired
	private SubscriberService subscriberService;
	
	@PostMapping("/addsubscriber")
	public String postSubscriber(@RequestParam("returnUrl") String returnUrl,SubscriberModel subscriberModel,RedirectAttributes redirectAttributes) {
		subscriberService.addSubscriber(subscriberModel);
		redirectAttributes.addAttribute("subscribe", "Thank u for subscribing");
		return "redirect:"+returnUrl;
	}
}
