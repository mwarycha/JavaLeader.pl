package pl.javaleader.LoadBalanced.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getWorker")
public class WorkerController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getPort() {
        return port;
    }
}