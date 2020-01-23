package pl.javaleader.springwebfluxreactiveweb;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import pl.javaleader.springwebfluxreactiveweb.model.Training;
import pl.javaleader.springwebfluxreactiveweb.repositories.TrainingRepository;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;

@Component
public class SampleDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private TrainingRepository trainingRepository;

    public SampleDataInitializer(TrainingRepository repository) {
        this.trainingRepository = repository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        Flux<Training>  trainingFlux = trainingRepository
                .findAll()
                .thenMany(
                        Flux
                                .just("JAVA", "SPRING")
                                .map(name -> new Training(UUID.randomUUID().toString(), name))
                                .flatMap(trainingRepository::save)
                );

        Mono<Void> all = Mono.when(trainingFlux);
        all.block();

        trainingRepository.findAll().subscribe(training -> System.out.println(training.getName()));

    }
}