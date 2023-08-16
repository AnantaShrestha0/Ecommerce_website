package com.box.ecommerce_website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class UserModel {

	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String email;
	private String password;
	@Transient
	private String confirmPassword;
	private int cartitems;
	
}
