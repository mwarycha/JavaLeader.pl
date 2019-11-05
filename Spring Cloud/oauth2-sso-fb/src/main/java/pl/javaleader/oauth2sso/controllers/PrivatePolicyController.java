package pl.javaleader.oauth2sso.controllers;

import org.springframework.ui.Model;
import pl.javaleader.oauth2sso.model.Contactdata;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivatePolicyController {
    @GetMapping("/private-policy")
    public String getPrivatePolicy(Model model) {
        model.addAttribute("contactdata", new Contactdata());
        return "private-policy";
    }
}
