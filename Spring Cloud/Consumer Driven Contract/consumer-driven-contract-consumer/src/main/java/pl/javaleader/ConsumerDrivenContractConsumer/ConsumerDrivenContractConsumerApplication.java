package pl.javaleader.ConsumerDrivenContractConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerDrivenContractConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDrivenContractConsumerApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
