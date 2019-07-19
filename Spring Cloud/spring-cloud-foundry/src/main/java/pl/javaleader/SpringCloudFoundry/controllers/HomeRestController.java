package pl.javaleader.SpringCloudFoundry.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("/message")
    String getMessage(@RequestParam(value = "param") String param) {
        return "msg: " + param;
    }
}
