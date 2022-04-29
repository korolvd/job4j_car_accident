package ru.job4j.accident.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Integer> {

    @Override
    List<Rule> findAll();

    Rule findById(int id);
}
