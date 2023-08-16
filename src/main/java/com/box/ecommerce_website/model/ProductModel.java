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
	private int currentPrice;
	private int oldPrice;
	private String image;
	private String stock;
	private int categoryId;
	private String category;
	
}
