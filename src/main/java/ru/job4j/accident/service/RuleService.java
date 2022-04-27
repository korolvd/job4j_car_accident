package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.store.RuleMemStore;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleMemStore store;

    public RuleService(RuleMemStore store) {
        this.store = store;
    }

    public Collection<Rule> findAll() {
        return store.findAll();
    }
}
