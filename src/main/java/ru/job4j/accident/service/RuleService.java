package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.store.RuleJdbcStore;
import ru.job4j.accident.store.RuleMemStore;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleJdbcStore store;

    public RuleService(RuleJdbcStore store) {
        this.store = store;
    }

    public Collection<Rule> findAll() {
        return store.findAll();
    }

    public Rule findById(int id) {
        return store.getById(id);
    }
}
