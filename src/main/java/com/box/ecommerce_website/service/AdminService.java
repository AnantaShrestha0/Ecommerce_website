package com.box.ecommerce_website.service;

import com.box.ecommerce_website.model.AdminModel;

public interface AdminService {

	void addAdmin(AdminModel adminModel);
	AdminModel findAdmin(String email,String password);
	
}
