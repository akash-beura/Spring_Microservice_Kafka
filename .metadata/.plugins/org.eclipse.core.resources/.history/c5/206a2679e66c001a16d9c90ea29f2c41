package com.mindtree.buyoutservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude=KafkaAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
public class BuyoutMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyoutMicroServiceApplication.class, args);
	}

}
