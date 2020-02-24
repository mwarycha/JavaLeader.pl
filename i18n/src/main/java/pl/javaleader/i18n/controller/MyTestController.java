package pl.javaleader.i18n.controller;

import java.util.Locale;
import org.springframework.context.MessageSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
 
    private MessageSource messageSource;
 
    @Autowired
    public MyTestController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
 
    @GetMapping("/welcome_en")
    public String welcomeEn() {
        return messageSource.getMessage("welcome_msg", null, Locale.ENGLISH);
    }

    @GetMapping("/welcome_pl")
    public String welcomePl() {
        Locale locale = new Locale("pl", "PL");
        return messageSource.getMessage("welcome_msg", null, locale);
    }
}
