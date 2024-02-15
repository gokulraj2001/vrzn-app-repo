package com.verizon.training.products;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Optional<Product> findByProductName(String productName);
}
