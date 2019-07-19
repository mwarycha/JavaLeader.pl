package pl.javaleader.spring.cloud.eureka.app.consumer.service;

import java.io.IOException;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {

    @Autowired
    private LoadBalancerClient loadBalancer;

    public String getEmployee(String url) throws RestClientException, IOException {

        ServiceInstance serviceInstance = loadBalancer.choose("app-producer");
        System.out.println(serviceInstance.getUri());
        String baseUrl=serviceInstance.getUri().toString()+url;
        RestTemplate restTemplate       = new RestTemplate();
        ResponseEntity<String> response = null;

        try {
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return response.getBody();

    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
        return new HttpEntity<>(headers);
    }

}