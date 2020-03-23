package com.mindtree.productkafkaservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mindtree.productkafkaservice.entity.Product;
import com.mindtree.productkafkaservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger logger;
	private List<Product> products;
	Product foundProduct = null;

	public Product getFoundProduct() {
		return foundProduct;
	}

	public void setFoundProduct(Product foundProduct) {
		this.foundProduct = foundProduct;
	}

	public ProductServiceImpl() {
		this.logger = LoggerFactory.getLogger(ProductServiceImpl.class);
		this.products = new ArrayList<>();
	}

	@KafkaListener(topics = "products", groupId = "group_json", containerFactory = "productKafkaListenerFactory")
	public void consumeProduct(Product product) {
		this.products.add(product);
		logger.debug("Added product to records, product name: " + product.getProductName());
	}

	@Override
	public List<Product> getAllProducts() {
		return this.products;
	}

	public Product getProductById(int id) {
		products = products.stream().filter(product -> {
			if (product.getProductId() == id) {
				setFoundProduct(product);
				return false;
			}
			return true;
		}).collect(Collectors.toList());
		return this.getFoundProduct();
	}

}
