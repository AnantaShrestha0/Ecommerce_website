package com.box.ecommerce_website.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.ecommerce_website.model.CartModel;

public interface CartRepo extends JpaRepository<CartModel, Integer>{

}
