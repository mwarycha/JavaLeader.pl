package pl.javaleader.allegroapi.configurations;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;
import pl.javaleader.allegroapi.interceptors.CustomHttpRequestInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public UserInfoRestTemplateCustomizer customHeader() {
        return restTemplate ->
                restTemplate.getInterceptors().add(new CustomHttpRequestInterceptor());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
