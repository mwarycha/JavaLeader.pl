package pl.javaleader.springcloudclient;

import pl.javaleader.springcloudclient.configurations.Configuration;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/*
	Ribbon is a client-side load balancer that gives you a lot of control over the behavior of HTTP and TCP clients

	Instead of relying on another service to distribute the load, the client itself, is responsible for deciding where to send the traffic also using an algorithm like round-robin.

	************************************************************************************************************
	It can either discover the instances, via service discovery, or can be configured with a predefined list.
	************************************************************************************************************

	In Java EE architecture, we deploy our war/ear files into multiple application servers, then we create a pool of server and put a load balancer (Netscaler) in front of it,
	which has a public IP. The client makes a request using that public IP, and Netscaler decides in which internal application server it forwards the request
	by round robin or sticky session algorithm. We call it server side load balancing.

	The problem of server side load balancing is if one or more servers stop responding, we have to manually remove those servers from
	the load balancer by updating the IP table of the load balancer. But microservices don't use server side load balancing. They use client side load balancing.

	To understand client side load balancing, let's recap microservices architecture. We generally create a service discovery like Eureka or Consul,
	where each service instance registers when bootstrapped. Eureka server maintains a service registry; it maintains all the instances of the service as
	a key/value map, where the {service id} of your microservice serves as the key and instances serve as the value. Now, if one microservice wants to communicate
	with another microservice, it generally looks up the service registry using DiscoveryClient and Eureka server returns all the instances of the calling microservice
	to the caller service. Then it was a caller service headache which instance it calls. Here, client side load balancing stepped in. Client side load balancing maintains
	an algorithm like round robin or zone specific, by which it can invoke instances of calling services. The advantage is s service registry always updates itself; if one
	instance goes down, it removes it from its registry, so when the client side load balancer talks to the Eureka server, it always updates itself, so there is no manual
	intervention- unlike server side load balancing- to remove an instance.

*/
@SpringBootApplication
@RibbonClient(name = "ribbon-client", configuration = Configuration.class)
public class SpringCloudClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClientApplication.class, args);
	}
}

