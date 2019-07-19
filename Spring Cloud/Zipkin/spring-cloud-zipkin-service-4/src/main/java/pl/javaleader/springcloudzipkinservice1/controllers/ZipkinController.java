package pl.javaleader.springcloudzipkinservice1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

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

    @GetMapping(value = "/zipkin4")
    public String zipkinService4() {
        LOG.info("Inside zipkinService 4..");
        return "Inside zipkinService 4..";
    }
}