package pl.javaleader.springcloudclient.controllers;

import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@RestController
public class WebController {

    @Autowired
    RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/helloworld")
    public String home() {
        return this.restTemplate.getForObject("http://helloworld/greeting", String.class);
    }
}