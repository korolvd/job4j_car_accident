package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Authority;
import ru.job4j.accident.store.AuthorityRepository;

@Service
public class AuthorityService {
    private final AuthorityRepository store;

    public AuthorityService(AuthorityRepository store) {
        this.store = store;
    }

    public Authority findByAuthority(String authority) {
        return store.findByAuthority(authority);
    }
}
