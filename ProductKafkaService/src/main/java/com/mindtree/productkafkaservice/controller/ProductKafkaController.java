package com.mindtree.productkafkaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.productkafkaservice.entity.Product;
import com.mindtree.productkafkaservice.service.ProductKafkaService;

@RestController
@RequestMapping("/publish")
public class ProductKafkaController {

	@Autowired
	private ProductKafkaService productService;

	@PostMapping("/product")
	public ResponseEntity<?> publishProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.publishProduct(product));
	}

}