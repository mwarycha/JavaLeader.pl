package pl.javaleader.oauth2sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2SsoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SsoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Oauth2SsoApplication.class);
	}

}
