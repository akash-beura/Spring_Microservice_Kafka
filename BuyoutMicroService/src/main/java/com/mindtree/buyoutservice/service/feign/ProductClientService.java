package com.mindtree.buyoutservice.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.buyoutservice.entity.Product;

@FeignClient(name="product-service")
public interface ProductClientService {

	@GetMapping("/product/{productId}")
	public Product getProductById(@PathVariable int productId);
}
