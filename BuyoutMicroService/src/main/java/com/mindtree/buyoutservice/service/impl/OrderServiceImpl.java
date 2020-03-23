package com.mindtree.buyoutservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.buyoutservice.entity.Product;
import com.mindtree.buyoutservice.service.OrderService;
import com.mindtree.buyoutservice.service.feign.ProductClientService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductClientService productClient;

	@Override
	public Product buyProduct(int productId) {
		return productClient.getProductById(productId);
	}
	
	
	
}
