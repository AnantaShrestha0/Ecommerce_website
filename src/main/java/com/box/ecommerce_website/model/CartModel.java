package com.box.ecommerce_website.model;



import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CartModel {

	
	@Id
	@GeneratedValue
	private int id;
	
	private int userId;
	
	@ManyToOne
	private ProductModel productModel;

	private int subtotal;
	private int quantity;
}
