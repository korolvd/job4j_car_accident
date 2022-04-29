package ru.job4j.accident.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @Override
    List<Accident> findAll();

    Accident findById(int id);
}
