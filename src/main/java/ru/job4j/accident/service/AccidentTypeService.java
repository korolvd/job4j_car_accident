package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.store.AccidentTypeHbmStore;
import ru.job4j.accident.store.AccidentTypeJdbcStore;
import ru.job4j.accident.store.AccidentTypeMemStore;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeHbmStore store;

    public AccidentTypeService(AccidentTypeHbmStore store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }

    public AccidentType findById(int id) {
        return store.findById(id);
    }
}
