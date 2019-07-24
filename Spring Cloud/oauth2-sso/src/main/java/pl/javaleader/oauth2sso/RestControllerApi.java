package pl.javaleader.oauth2sso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApi {

    @GetMapping("/public")
    String getPublicContent(){
        return "getPublicContent";
    }

    @GetMapping("/private")
    String getPrivateContent(){
        return "getPrivateContent";
    }
}
