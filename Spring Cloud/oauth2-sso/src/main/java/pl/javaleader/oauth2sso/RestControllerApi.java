package pl.javaleader.oauth2sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApi {

    @Autowired
    private OAuth2ClientContext clientContext;

    @GetMapping("/token")
    String showToken() {
        return clientContext.getAccessToken().getValue();
    }

    @GetMapping("/public")
    String getPublicContent(){
        return "getPublicContent";
    }

    @GetMapping("/private")
    String getPrivateContent(){
        return "getPrivateContent";
    }

    @GetMapping("/")
    String home(){
        return "OAuth HomePageApp";
    }
}
