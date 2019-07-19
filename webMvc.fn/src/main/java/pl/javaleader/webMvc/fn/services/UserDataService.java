package pl.javaleader.webMvc.fn.services;

import pl.javaleader.webMvc.fn.models.User;
import java.util.List;

public interface UserDataService {
     List<User> getAllUsers();
     void addNewUser(User jsonUser);
}
