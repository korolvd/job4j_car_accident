package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.store.AccidentMemStore;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentMemStore store;

    public AccidentService(AccidentMemStore store) {
        this.store = store;
    }

    public Collection<Accident> findAll() {
        return store.findAll();
    }

    public void add(Accident accident) {
        store.add(accident);
    }
}
