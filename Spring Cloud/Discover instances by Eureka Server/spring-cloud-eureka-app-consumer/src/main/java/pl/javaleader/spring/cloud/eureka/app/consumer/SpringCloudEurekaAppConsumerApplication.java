package pl.javaleader.spring.cloud.eureka.app.consumer;

import pl.javaleader.spring.cloud.eureka.app.consumer.service.Client;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudEurekaAppConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaAppConsumerApplication.class, args);
	}

	@Bean
	public Client client() {
		return  new Client();
	}
}

