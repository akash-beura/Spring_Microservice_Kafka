package com.mindtree.buyoutservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.buyoutservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/product/{productId}")
	public ResponseEntity<?> buyProduct(@PathVariable int productId) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.buyProduct(productId));
	}

}