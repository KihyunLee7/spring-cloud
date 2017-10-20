package com.example.demo;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	private final RestTemplate restTemplate;
	
	public TestService(RestTemplate rest) {
		this.restTemplate = rest;
		
	}
	
	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		URI uri = URI.create("http://localhost:9999/hello/id");
		
		return this.restTemplate.getForObject(uri, String.class);
	}
	
	public String reliable() {
		return "ERROR API Service";
	}
	
}
