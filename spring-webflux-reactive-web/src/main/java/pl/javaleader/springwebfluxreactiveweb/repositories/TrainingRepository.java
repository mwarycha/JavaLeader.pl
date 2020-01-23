package pl.javaleader.springwebfluxreactiveweb.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.javaleader.springwebfluxreactiveweb.model.Training;

import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends ReactiveMongoRepository<Training, String> {
}