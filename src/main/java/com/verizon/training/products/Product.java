package com.verizon.training.products;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private float price;
	
}
