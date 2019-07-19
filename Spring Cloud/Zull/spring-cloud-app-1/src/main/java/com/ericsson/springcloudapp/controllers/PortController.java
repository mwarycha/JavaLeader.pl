package com.ericsson.springcloudapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {

    @RequestMapping
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/port")
    public String appPort() {
        return "app port: 8081";
    }
}