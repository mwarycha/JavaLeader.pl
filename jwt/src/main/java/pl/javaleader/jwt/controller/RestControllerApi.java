package pl.javaleader.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApi {

    @GetMapping("/getMsg")
    public String getMsg(){
        return "msg permit all";
    }

    @GetMapping("/getSecuredMsg")
    public String getSecuredMsg(){
        return "msg secured";
    }
}
