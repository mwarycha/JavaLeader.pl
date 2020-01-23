package pl.javaleader.springwebfluxreactiveweb.controllers;

import org.springframework.http.MediaType;
import pl.javaleader.springwebfluxreactiveweb.model.Training;
import pl.javaleader.springwebfluxreactiveweb.repositories.TrainingRepository;
import reactor.core.publisher.Flux;
import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    private final TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository bookRepository) {
        this.trainingRepository = bookRepository;
    }

    @GetMapping(value = "/trainings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Training> getBooks() {
        return trainingRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

}