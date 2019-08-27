package pl.edusession.javamailapp.controllers;

import pl.edusession.javamailapp.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailApi {

    private MailService mailService;

    @Autowired
    public MailApi(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendTestMail")
    public String sendMail() throws javax.mail.MessagingException {
        mailService.sendMail("kontakt@javaleader.pl",
                "test message from spring boot mail api",
                "test message",
                true);
        return "message has been sent!";
    }
}