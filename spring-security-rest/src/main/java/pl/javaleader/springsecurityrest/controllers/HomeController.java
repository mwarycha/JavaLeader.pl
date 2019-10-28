package pl.javaleader.springsecurityrest.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.javaleader.springsecurityrest.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.annotation.Secured;

@RestController
public class HomeController {

    @Secured("ROLE_USER")
    @GetMapping("/")
    public UserDto userDto() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities().forEach(role -> System.out.println("[log] " + role));
        return new UserDto("user", "password");
    }
}