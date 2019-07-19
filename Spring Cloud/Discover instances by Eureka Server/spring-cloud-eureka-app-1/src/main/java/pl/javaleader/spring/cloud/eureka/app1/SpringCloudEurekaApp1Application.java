package pl.javaleader.spring.cloud.eureka.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaApp1Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaApp1Application.class, args);
	}

}