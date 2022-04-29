package ru.job4j.accident.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.store.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccidentService {
    private static final Logger LOGGER = Logger.getLogger(AccidentService.class);
    private final AccidentRepository store;

    public AccidentService(AccidentRepository store, RuleRepository ruleStore) {
        this.store = store;
    }

    public Collection<Accident> findAll() {
        return store.findAll();
    }

    public void add(Accident accident) {
        store.save(accident);
    }

    public Accident findById(int id) {
        return store.findById(id);
    }

    public void update(Accident accident) {
        store.save(accident);
    }
}
