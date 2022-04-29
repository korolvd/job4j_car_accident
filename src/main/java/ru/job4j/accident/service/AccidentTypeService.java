package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.store.*;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeRepository store;

    public AccidentTypeService(AccidentTypeRepository store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }

    public AccidentType findById(int id) {
        return store.findById(id);
    }
}
