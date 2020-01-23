package pl.javaleader.springwebfluxreactiveweb.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.javaleader.springwebfluxreactiveweb.model.Training;
import pl.javaleader.springwebfluxreactiveweb.repositories.TrainingRepository;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class TrainingHandler {
 
    private final TrainingRepository trainingRepository;

    public TrainingHandler(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Mono<ServerResponse> getTrainings(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(trainingRepository.findAll().delayElements(Duration.ofSeconds(5)),
                  Training.class);
    }
}