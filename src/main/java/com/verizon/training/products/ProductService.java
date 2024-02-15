package com.verizon.training.products;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository repo;

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	Optional<Product> getProductById(int id) {
		return repo.findById(id);
	}
	
	Optional<Product> getByProductName(String productName) {
		return repo.findByProductName(productName);
	}
	
	void addProduct(Product product) {
		repo.save(product);
	}
	
	void updateProduct(Product product) {
		repo.save(product);
	}
	
	void deleteProduct(int id) {
		repo.deleteById(id);
	}
}
