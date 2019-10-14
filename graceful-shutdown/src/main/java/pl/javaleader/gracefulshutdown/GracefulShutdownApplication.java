package pl.javaleader.gracefulshutdown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import pl.javaleader.gracefulshutdown.components.TomcatGracefulShutdownConnector;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GracefulShutdownApplication {

	public static void main(String[] args) {
		SpringApplication.run(GracefulShutdownApplication.class, args);
	}


	@Bean
	public TomcatGracefulShutdownConnector tomcatGracefulShutdownConnector() {
		return new TomcatGracefulShutdownConnector();
	}

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory(final TomcatGracefulShutdownConnector tomcatGracefulShutdownConnector) {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addConnectorCustomizers(tomcatGracefulShutdownConnector);
		return factory;
	}
}
