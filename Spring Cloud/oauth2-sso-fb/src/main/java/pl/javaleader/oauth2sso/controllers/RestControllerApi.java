package pl.javaleader.oauth2sso.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import java.security.Principal;
import pl.javaleader.oauth2sso.model.EmailUserRepository;
import pl.javaleader.oauth2sso.repositories.EmailRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApi {

    private final EmailRepository emailRepository;

    public RestControllerApi(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @RequestMapping("/user")
    public Principal userPrincipal(Principal principal) {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        oAuth2Authentication.getAuthorities().forEach(x ->System.out.println(x));
        saveEmail(principal.getName());
        return principal;
    }

    private void saveEmail(String email) {
        if(emailRepository.findByEmail(email).size() == 0) {
            emailRepository.save(new EmailUserRepository(email));
        }
    }
}
