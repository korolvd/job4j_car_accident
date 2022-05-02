package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.store.UserRepository;

@Service
public class UserService {
    private final UserRepository store;

    public UserService(UserRepository store) {
        this.store = store;
    }

    public void save(User user) {
        store.save(user);
    }
}
