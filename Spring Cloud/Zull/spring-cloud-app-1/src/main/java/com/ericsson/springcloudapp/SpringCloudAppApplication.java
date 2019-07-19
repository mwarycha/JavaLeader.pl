package com.ericsson.springcloudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAppApplication.class, args);
	}
}

