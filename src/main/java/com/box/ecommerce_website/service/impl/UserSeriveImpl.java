package com.box.ecommerce_website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.ecommerce_website.model.UserModel;
import com.box.ecommerce_website.repo.UserRepo;
import com.box.ecommerce_website.service.UserService;

@Service
public class UserSeriveImpl implements UserService{

	@Autowired
	public UserRepo userRepo;
	
	
	@Override
	public void addUser(UserModel userModel) {
		// TODO Auto-generated method stub
		userRepo.save(userModel);
	}

	@Override
	public UserModel findUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public UserModel findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

}
