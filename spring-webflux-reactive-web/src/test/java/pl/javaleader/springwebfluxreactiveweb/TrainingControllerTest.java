package pl.javaleader.springwebfluxreactiveweb;

import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.javaleader.springwebfluxreactiveweb.model.Training;
import java.time.Duration;
import java.util.UUID;
import pl.javaleader.springwebfluxreactiveweb.repositories.TrainingRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class TrainingControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private  TrainingRepository trainingRepository;

    @Before
    public void setUp()  {
        webTestClient = webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(50))
                .build();
    }

    @Test
    public void trainingsTest() {

        trainingRepository.findAll().subscribe(training -> System.out.println("[TRAINING TEST] " + training.getName()));

        Flux<Training> trainingStreamFlux = webTestClient.get().uri("/trainings")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Training.class)
                .getResponseBody();

        StepVerifier.create(trainingStreamFlux)
                .expectNext( new Training(UUID.randomUUID().toString(), "JAVA"))
                .expectNext( new Training(UUID.randomUUID().toString(), "SPRING"))
                .thenCancel()
                .verify();
    }
}