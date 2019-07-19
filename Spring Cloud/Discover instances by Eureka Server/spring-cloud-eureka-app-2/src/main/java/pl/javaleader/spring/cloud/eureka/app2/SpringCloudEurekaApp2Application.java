package pl.javaleader.spring.cloud.eureka.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaApp2Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaApp2Application.class, args);
	}

}

