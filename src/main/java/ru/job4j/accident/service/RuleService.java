package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.store.RuleHbmStore;
import ru.job4j.accident.store.RuleJdbcStore;
import ru.job4j.accident.store.RuleMemStore;
import ru.job4j.accident.store.RuleRepository;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleRepository store;

    public RuleService(RuleRepository store) {
        this.store = store;
    }

    public Collection<Rule> findAll() {
        return store.findAll();
    }

    public Rule findById(int id) {
        return store.findById(id);
    }
}
