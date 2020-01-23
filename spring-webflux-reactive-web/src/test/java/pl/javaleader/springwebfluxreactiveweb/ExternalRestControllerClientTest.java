package pl.javaleader.springwebfluxreactiveweb;

import org.springframework.web.reactive.function.client.WebClient;
import pl.javaleader.springwebfluxreactiveweb.model.Training;

import org.junit.Test;

public class ExternalRestControllerClientTest {

    @Test
    public void trainingsTest() {
        WebClient.create("http://localhost:7774")
                .get()
                .uri("/trainings")
                .retrieve()
                .bodyToFlux(Training.class)
                .doOnNext(training -> System.out.println("[training]: " + training.getName()))
                .blockLast();
    }
}
