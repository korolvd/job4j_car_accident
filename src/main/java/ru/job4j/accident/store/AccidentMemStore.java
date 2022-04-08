package ru.job4j.accident.store;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMemStore {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    public AccidentMemStore() {
        accidents.put(1, new Accident(1, "Ivanov", "Accident 1", "Street 1"));
        accidents.put(2, new Accident(2, "Petrov", "Accident 2", "Street 2"));
        accidents.put(3, new Accident(3, "Sidorov", "Accident 3", "Street 3"));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }
}
