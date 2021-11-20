package pl.javaleader.keycloak.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api")
public class Api {

    @RolesAllowed({"User", "Moderator", "Admin"})
    @RequestMapping(value = "/readPost", method = RequestMethod.GET)
    public ResponseEntity<String> readPost() {
        return ResponseEntity.ok("USER ACCESS");
    }

    @RolesAllowed("Moderator")
    @RequestMapping(value = "/modifyPost", method = RequestMethod.GET)
    public ResponseEntity<String> modifyPost() {
        return ResponseEntity.ok("MODERATOR ACCESS");
    }

    @RolesAllowed("Admin")
    @RequestMapping(value = "/deletePost", method = RequestMethod.GET)
    public ResponseEntity<String> deletePost() {
        return ResponseEntity.ok("ADMIN ACCESS");
    }
}