package services;

import models.AuthRequest;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Припустимо, що у вас є клас UserRepository для доступу до користувачів у базі даних
    private final UserRepository userRepository;

    public <UserRepository> AuthService(UserRepository userRepository) {
        this.userRepository = (services.UserRepository) userRepository;
    }

    public boolean authenticate(AuthRequest authRequest) {
        // Отримання ім'я користувача та пароля з об'єкта AuthRequest
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        // Пошук користувача у базі даних за ім'ям користувача
        User user = userRepository.findByUsername(username);

        // Перевірка чи знайдений користувач і чи відповідає пароль
        return user != null && user.getPassword().equals(password);
    }
}

