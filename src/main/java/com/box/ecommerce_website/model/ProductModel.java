package com.box.ecommerce_website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductModel {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String currentPrice;
	private String oldprice;
	private String color;
	private String size;
	private String photo;
	private String quantity;
	
}
