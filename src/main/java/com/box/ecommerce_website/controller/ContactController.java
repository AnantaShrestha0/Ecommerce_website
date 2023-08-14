package com.box.ecommerce_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.ecommerce_website.model.SubscriberModel;
import com.box.ecommerce_website.service.SubscriberService;
import com.box.ecommerce_website.util.MailUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {

	@Autowired
	private SubscriberService subscriberService;
	
	
	@Autowired
	private MailUtil mailUtil;
	
	@PostMapping("/addsubscriber")
	public String postSubscriber(@RequestParam("returnUrl") String returnUrl,SubscriberModel subscriberModel,RedirectAttributes redirectAttributes) {
		subscriberService.addSubscriber(subscriberModel);
		redirectAttributes.addAttribute("subscribe", "Thank u for subscribing");
		return "redirect:"+returnUrl;
	}
	
	@PostMapping("/contactus")
	public String postContact(@RequestParam String fullname,@RequestParam String email,@RequestParam String phonenumber,@RequestParam String message,HttpSession httpSession,RedirectAttributes redirectAttributes) {
		
//		if(httpSession.getAttribute("validuser")==null) {
//			return "login";
//		}

		String toEmail="anantashrestha45@gmail.com";
		String Message="Full name : "+fullname+"\nEmail: "+email+"\nPhone Number: "+phonenumber+"\nMessage: "+message;
		String subject="Information";
		mailUtil.sendEmail(toEmail,subject,Message);
		redirectAttributes.addFlashAttribute("message", "Message send successfully.");
		return "redirect:/contactus";
	}
	
}
