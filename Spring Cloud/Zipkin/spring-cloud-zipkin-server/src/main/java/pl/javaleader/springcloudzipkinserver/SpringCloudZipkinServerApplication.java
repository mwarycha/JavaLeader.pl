package pl.javaleader.springcloudzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

// to enable the Zipkin server, we must add some annotations to the main application class
// https://cloud.spring.io/spring-cloud-static/spring-cloud-sleuth/1.3.4.RELEASE/single/spring-cloud-sleuth.html

// So if we count the physical spans we have 1 from http:/start, 2 from service1 calling service2, 2 form service2 calling service3 and 2 from service2 calling service4. Altogether 7 spans.
// Logically we see the information of Total Spans: 4 because we have 1 span related to the incoming request to service1 and 3 spans related to RPC calls.
@SpringBootApplication
@EnableZipkinServer
public class SpringCloudZipkinServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinServerApplication.class, args);
	}

}

