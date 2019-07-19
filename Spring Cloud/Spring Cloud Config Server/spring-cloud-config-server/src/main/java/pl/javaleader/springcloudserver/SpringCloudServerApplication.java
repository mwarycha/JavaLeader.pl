package pl.javaleader.springcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
	Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system.
	Spring Cloud Config is Spring’s client/server approach for storing and serving distributed configurations across multiple applications and environments.
	With the Config Server you have a central place to manage external properties for applications across all environments.

	This application setup a Config Server and then build a client that consumes the configuration on startup and then refreshes the configuration without restarting the client.

*/
@SpringBootApplication
@EnableConfigServer
public class SpringCloudServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerApplication.class, args);
	}
}