package pl.javaleader.monitoringmicrometer.service;

import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Service
public class SendEmail {
    @Timed(value = "email.delivery.time", description = "Time taken to send email")
    public void sendEmail(int amount) {
        for (int i = 0; i < amount; i++) {
            try {
                sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
