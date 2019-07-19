package pl.javaleader.ConsumerDrivenContractConsumer.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculatorController {

    private final RestTemplate restTemplate;

    public CalculatorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/addition")
    ResponseEntity<String> addition(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/calculate/addition/2/3",
                HttpMethod.GET,
                entity,
                String.class);
    }

    @GetMapping("/subtract")
    ResponseEntity<String> subtract(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/calculate/subtract/2/3",
                HttpMethod.GET,
                entity,
                String.class);
    }

    @GetMapping("/multiply")
    ResponseEntity<String> multiply(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/calculate/multiply/2/3",
                HttpMethod.GET,
                entity,
                String.class);
    }

    @GetMapping("/division")
    ResponseEntity<String> division(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/calculate/division/10/2",
                HttpMethod.GET,
                entity,
                String.class);
    }

}
