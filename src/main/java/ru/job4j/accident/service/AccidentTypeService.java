package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.store.AccidentTypeMemStore;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeMemStore store;

    public AccidentTypeService(AccidentTypeMemStore store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }
}
