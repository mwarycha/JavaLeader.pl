package pl.javaleader.cors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.javaleader.cors.model.User;
import pl.javaleader.cors.repositories.UserRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class CorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsApplication.class, args);
	}

	@Bean
	CommandLineRunner initialize(UserRepository userRepository) {
		return args -> {

			Stream.of("Eric", "James", "Martin").forEach(name -> {
				User user = new User(name);
				userRepository.save(user);
			});
		};
	}

}
