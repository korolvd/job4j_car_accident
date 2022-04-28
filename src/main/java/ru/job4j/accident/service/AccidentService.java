package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.store.AccidentHbmStore;
import ru.job4j.accident.store.AccidentJdbcTemplate;
import ru.job4j.accident.store.AccidentMemStore;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentHbmStore store;

    public AccidentService(AccidentHbmStore store) {
        this.store = store;
    }

    public Collection<Accident> findAll() {
        return store.findAll();
    }

    public void add(Accident accident) {
        store.add(accident);
    }

    public Accident findById(int id) {
        return store.findById(id);
    }

    public void update(Accident accident) {
        store.update(accident);
    }
}
