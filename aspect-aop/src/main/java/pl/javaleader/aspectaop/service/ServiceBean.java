package pl.javaleader.aspectaop.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceBean {
    public String getMsg() {
        return "service bean msg";
    }
}
