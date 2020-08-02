package pl.javaleader.graphql.services;

import pl.javaleader.graphql.model.User;
import pl.javaleader.graphql.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository ;

    public UserService(final UserRepository vehicleRepository) {
        this.userRepository = vehicleRepository ;
    }

    @Transactional
    public User createUser(final String name,final String surname) {
        final User user = new User();
        user.setName(name);
        user.setSurname(surname);
        return this.userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> gelAllUsers(final int count) {
        return this.userRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(final int id) {
        return this.userRepository.findById(id);
    }

}