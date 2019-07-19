package pl.javaleader.webMvc.fn.controllers;

import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import pl.javaleader.webMvc.fn.models.User;
import pl.javaleader.webMvc.fn.services.UserDataService;
import java.io.IOException;
import java.net.URI;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class ConfigurationControllersRouting {

    @Autowired
    UserDataService userDataService;

    @Component
    class Handler {
        public ServerResponse handlePost(ServerRequest serverRequest)
                throws ServletException, IOException {
            userDataService.addNewUser(serverRequest.body(User.class));
            return ServerResponse.created(URI.create("/location")).build();
        }
    }

    @Bean
    public RouterFunction<ServerResponse> routes(Handler handler) {
        return route()

                .GET("/getAllUsers", serverRequest -> ServerResponse.ok().body(userDataService.getAllUsers()))

                .POST("/addNewUser", handler::handlePost)
                .build();
    }
}
