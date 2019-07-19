package pl.javaleader.webMvc.fn.utils;

import pl.javaleader.webMvc.fn.models.User;
import java.util.ArrayList;
import java.util.List;

public class UsersDatabaseHelper {

    static List<User> users = new ArrayList();

    static {
        User user1 = new User("user-1", "user-1");
        User user2 = new User("user-2", "user-2");
        User user3 = new User("user-3", "user-3");
        User user4 = new User("user-4", "user-4");
        User user5 = new User("user-5", "user-5");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    public static List<User> getAllUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

}
