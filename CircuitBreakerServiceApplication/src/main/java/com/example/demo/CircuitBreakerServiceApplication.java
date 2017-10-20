package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@RestController
@EnableEurekaClient
public class CircuitBreakerServiceApplication {

	@Autowired
	private TestService testService;
	
	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	@RequestMapping("/test")
	public String toRead() {
		return testService.readingList();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerServiceApplication.class, args);
	}
}
