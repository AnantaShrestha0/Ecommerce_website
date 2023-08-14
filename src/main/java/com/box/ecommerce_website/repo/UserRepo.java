package com.box.ecommerce_website.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.ecommerce_website.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
	
    UserModel findByEmail(String email);
    UserModel findByEmailAndPassword(String email,String password);
}
