package com.box.ecommerce_website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SubscriberModel {

	@Id
	@GeneratedValue
	private int id;
	private String email;
	
}
