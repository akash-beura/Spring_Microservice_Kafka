package com.mindtree.productkafkaservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.mindtree.productkafkaservice.entity.Product;

@Configuration
@EnableKafka
public class ProductKafkaConfig {

	@Bean
	public ConsumerFactory<String, String> kafkaConsumerFactory(){
		Map<String, Object> configs = new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_one");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configs);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(kafkaConsumerFactory());
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, Product> productConsumerFactory(){
		Map<String, Object> configs = new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(Product.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Product> productKafkaListenerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Product> factory = new ConcurrentKafkaListenerContainerFactory<String, Product>();
		factory.setConsumerFactory(productConsumerFactory());
		return factory;
	}
	
	
	
	
}
