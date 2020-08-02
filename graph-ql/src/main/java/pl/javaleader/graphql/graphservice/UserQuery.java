package pl.javaleader.graphql.graphservice;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import pl.javaleader.graphql.model.User;
import pl.javaleader.graphql.services.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public List<User> getUsers(final int count) {
        return this.userService.gelAllUsers(count);
    }

    public Optional<User> getUser(final int id) {
        return this.userService.getUser(id);
    }

}