package pl.javaleader.springwebfluxreactiveweb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.javaleader.springwebfluxreactiveweb.model.Training;

import java.time.Duration;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class TrainingControllerTest {
 
    @Autowired
    WebTestClient webTestClient;
 
    @Before
    public void setUp() throws Exception {
        webTestClient = webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(20))
                .build();
    }
 
    @Test
    public void messageWhenNotAuthenticated() throws Exception {
        this.webTestClient
                .get()
                .uri("/trainings")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Training.class)
                .isEqualTo(Arrays.asList(
                        new Training("JPA")));
    }
}