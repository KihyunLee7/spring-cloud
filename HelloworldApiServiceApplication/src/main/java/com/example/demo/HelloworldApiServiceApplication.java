package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class HelloworldApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApiServiceApplication.class, args);
	}
	
}


@RefreshScope
@RestController
class MessageRestController {
	@Value("${eureka.instance.metadataMap.instanceId}")
	private String instanceId;
	
	@RequestMapping("/id")
	String instanceId() {
		return this.instanceId;
	}
}
