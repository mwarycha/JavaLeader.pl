package pl.javaleader.graphql.graphservice;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import pl.javaleader.graphql.model.User;
import pl.javaleader.graphql.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(final String name, final String surname) {
        return this.userService.createUser(name, surname);
    }
}