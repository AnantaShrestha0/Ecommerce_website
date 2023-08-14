package com.box.ecommerce_website.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.ecommerce_website.model.AdminModel;

public interface AdminRepo extends JpaRepository<AdminModel, Integer> {

	AdminModel findByEmailAndPassword(String email,String password);
}
