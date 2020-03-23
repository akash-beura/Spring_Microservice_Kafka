package com.mindtree.productservice.service;

import java.util.List;

import com.mindtree.productservice.entity.Product;

public interface ProductService {
	
	public void consumeProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(int id);

}
