package pl.javaleader.oauth2sso.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApi {
    @RequestMapping("/user")
    public Principal userPrincipal(Principal principal) {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        oAuth2Authentication.getAuthorities().forEach(x ->System.out.println(x));
        return principal;
    }
}
