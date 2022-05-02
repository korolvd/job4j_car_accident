package ru.job4j.accident.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
