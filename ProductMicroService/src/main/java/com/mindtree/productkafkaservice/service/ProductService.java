package com.mindtree.productkafkaservice.service;

import java.util.List;

import com.mindtree.productkafkaservice.entity.Product;

public interface ProductService {
	
	public void consumeProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(int id);

}
