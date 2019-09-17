package pl.edusession.javamailapp;

import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.ServerSetup;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edusession.javamailapp.service.MailService;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("e-mail")
@RunWith(SpringRunner.class)
public class EmailSenderTest {

    @Rule
    public GreenMailRule server = new GreenMailRule(new ServerSetup(25, "localhost", "smtp"));

    @Autowired
    MailService mailService;

    @Test
    public void shouldSendEmail() throws Exception {

        server.setUser("kontakt@javaleader.pl", "javaleader.pl", "password");

        String to      = "kontakt@javaleader.pl";
        String subject = "javaleader.pl";
        String content = "content email";

        mailService.sendMail(to, subject, content, false);

        MimeMessage[] receivedMessages = server.getReceivedMessages();
        MimeMessage receivedMessage    = receivedMessages[0];

        assertThat(receivedMessages.length).isEqualTo(1);

        assertThat(receivedMessage.getAllRecipients()[0].toString()).isEqualTo(to);
    }

}
