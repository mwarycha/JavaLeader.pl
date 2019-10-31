package pl.javaleader.oauth2sso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestControllerApi {
    @GetMapping("/")
    String getPublicContent() {
        return "index";
    }
}
