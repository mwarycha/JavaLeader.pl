package pl.javaleader.oauth2sso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javaleader.oauth2sso.model.Contactdata;

@Controller
public class PrivatePolicyController {

    @GetMapping("/private-policy")
    public String getPrivatePolicy(Model model) {
        model.addAttribute("contactdata", new Contactdata());
        return "private-policy";
    }

}
