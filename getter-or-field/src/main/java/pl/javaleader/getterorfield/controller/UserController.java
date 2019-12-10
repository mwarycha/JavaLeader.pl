package pl.javaleader.getterorfield.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javaleader.getterorfield.model.User;
import pl.javaleader.getterorfield.repo.UserRepo;

@RestController
public class UserController {

    UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String saveUser() {
        User user = new User("James", "Spring");
        userRepo.save(user);
        return "saved";
    }

}
