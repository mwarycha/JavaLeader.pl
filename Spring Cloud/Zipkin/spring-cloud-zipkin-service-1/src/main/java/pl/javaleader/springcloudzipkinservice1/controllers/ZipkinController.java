package pl.javaleader.springcloudzipkinservice1.controllers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
class ZipkinController{

    @Autowired
    RestTemplate restTemplate;

    /*
        You have to register RestTemplate as a bean so that the interceptors will get injected.
        If you create a RestTemplate instance with a new keyword then the instrumentation WILL NOT work.
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    private static final Logger LOG = Logger.getLogger(ZipkinController.class.getName());

    @GetMapping(value="/zipkin1")
    public String zipkinService1()
    {
        LOG.info("Inside zipkinService 1...");

        String response = (String) restTemplate.exchange("http://localhost:8082/zipkin2", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return "Inside zipkinService 1.." + response;
    }
}