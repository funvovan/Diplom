package services;

import org.apache.catalina.User;

import java.util.List;

public class UserService {
    public User createUser(User user) {
        return user;
    }

    public User updateUser(Long userId, User user) {
        return user;
    }

    public boolean deleteUser(Long userId) {
        return false;
    }

    public boolean authenticate(String username, String password) {
        return false;
    }

    public List<User> getAllUsers() {
        return List.of();
    }
}
