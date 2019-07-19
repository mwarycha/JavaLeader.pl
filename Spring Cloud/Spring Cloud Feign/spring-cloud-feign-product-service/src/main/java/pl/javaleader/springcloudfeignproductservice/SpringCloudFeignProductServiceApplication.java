package pl.javaleader.springcloudfeignproductservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudFeignProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignProductServiceApplication.class, args);
	}
}

