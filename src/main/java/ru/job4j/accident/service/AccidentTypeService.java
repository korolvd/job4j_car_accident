package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.store.AccidentTypeJdbcStore;
import ru.job4j.accident.store.AccidentTypeMemStore;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeJdbcStore store;

    public AccidentTypeService(AccidentTypeJdbcStore store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }

    public AccidentType findById(int id) {
        return store.getById(id);
    }
}
