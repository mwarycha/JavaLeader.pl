package pl.javaleader.springintegrationactivemqspringboot;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:/context-config.xml")
public class SpringIntegrationActiveMqSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationActiveMqSpringBootApplication.class, args);
	}
}
