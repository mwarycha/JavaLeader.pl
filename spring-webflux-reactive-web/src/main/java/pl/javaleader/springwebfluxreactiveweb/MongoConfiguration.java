package pl.javaleader.springwebfluxreactiveweb;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.javaleader.springwebfluxreactiveweb.handlers.TrainingHandler;
import pl.javaleader.springwebfluxreactiveweb.repositories.TrainingRepository;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = TrainingRepository.class)
public class MongoConfiguration {
    @Bean
    public RouterFunction<ServerResponse> booksRoute(TrainingHandler trainingHandler) {
        return RouterFunctions.route(GET("/trainings-handler"), trainingHandler::getTrainings);
    }
}

