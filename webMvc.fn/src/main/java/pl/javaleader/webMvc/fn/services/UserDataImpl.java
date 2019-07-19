package pl.javaleader.webMvc.fn.services;

import pl.javaleader.webMvc.fn.models.User;
import pl.javaleader.webMvc.fn.utils.UsersDatabaseHelper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
class UserDataServiceImpl implements UserDataService {

    @Override
    public List<User> getAllUsers() {
        return UsersDatabaseHelper.getAllUsers();
    }

    @Override
    public void addNewUser(User jsonUser) {
        UsersDatabaseHelper.addUser(jsonUser);
    }
}
