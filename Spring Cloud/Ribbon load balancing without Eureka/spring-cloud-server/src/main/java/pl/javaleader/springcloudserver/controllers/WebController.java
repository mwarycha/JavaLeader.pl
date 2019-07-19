package pl.javaleader.springcloudserver.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/")
    public String home() {
        return "Okay!";
    }

    @RequestMapping("/greeting")
    public String hello() {
        return "Hello from a service running at port: " + port + "!";
    }
}