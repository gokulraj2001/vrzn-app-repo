package com.verizon.training.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping
	List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	Optional<Product> getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/name/{name}")
	Optional<Product> getByProductName(@PathVariable String name) {
		return service.getByProductName(name);
	}
	
	@PostMapping
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	@PutMapping
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	void deleteProduct(@PathVariable int id) {
		service.deleteProduct(id);
	}
}
