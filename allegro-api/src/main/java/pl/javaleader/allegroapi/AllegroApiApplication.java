package pl.javaleader.allegroapi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.SpringApplication;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableResourceServer
public class AllegroApiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AllegroApiApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AllegroApiApplication.class);
	}
}
