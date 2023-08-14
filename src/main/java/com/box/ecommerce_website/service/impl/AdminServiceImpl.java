package com.box.ecommerce_website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.ecommerce_website.model.AdminModel;
import com.box.ecommerce_website.repo.AdminRepo;
import com.box.ecommerce_website.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public void addAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		adminRepo.save(adminModel);
	}

	@Override
	public AdminModel findAdmin(String email,String password){
		// TODO Auto-generated method stub
		return adminRepo.findByEmailAndPassword(email, password);
	}

}
