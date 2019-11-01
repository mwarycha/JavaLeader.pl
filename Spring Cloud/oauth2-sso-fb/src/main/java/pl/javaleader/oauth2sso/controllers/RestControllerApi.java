package pl.javaleader.oauth2sso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestControllerApi {
    @GetMapping("/")
    String getPublicContent() {
        return "index";
    }
}
