package pl.javaleader.monitoringmicrometer.controller;

import pl.javaleader.monitoringmicrometer.service.SendEmail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    SendEmail sendEmail;

    public EmailController(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @GetMapping("/send-email")
    public void sendEmail(@RequestParam int emailAmount) {
        sendEmail.sendEmail(emailAmount);
    }
}
