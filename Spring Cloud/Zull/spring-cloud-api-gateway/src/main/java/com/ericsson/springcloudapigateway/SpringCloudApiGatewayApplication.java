package com.ericsson.springcloudapigateway;

import com.ericsson.springcloudapigateway.filters.SimpleFilter;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApiGatewayApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
}

