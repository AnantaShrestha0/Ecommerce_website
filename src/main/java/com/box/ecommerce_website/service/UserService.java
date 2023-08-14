package com.box.ecommerce_website.service;

import com.box.ecommerce_website.model.UserModel;

public interface UserService {

	
	void addUser(UserModel userModel);
	UserModel findUser(String email,String password);
	UserModel findUserByEmail(String email);
	
}
