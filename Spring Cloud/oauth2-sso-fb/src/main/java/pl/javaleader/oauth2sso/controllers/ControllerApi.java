package pl.javaleader.oauth2sso.controllers;

import org.springframework.ui.Model;
import pl.javaleader.oauth2sso.model.Contactdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerApi {

    @GetMapping("/")
    public String getPublicContent(Model model) {
        model.addAttribute("contactdata", new Contactdata());
        return "index";
    }

    @GetMapping("/upload")
    public String getUpload(Model model) {
        model.addAttribute("contactdata", new Contactdata());
        return "upload";
    }
}
