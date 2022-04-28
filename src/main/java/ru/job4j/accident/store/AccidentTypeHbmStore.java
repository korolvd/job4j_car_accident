package ru.job4j.accident.store;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.List;

@Repository
public class AccidentTypeHbmStore implements HbmStore {
    private final SessionFactory sf;

    public AccidentTypeHbmStore(SessionFactory sf) {
        this.sf = sf;
    }

    public List<AccidentType> findAll() {
        return transaction(session -> session.createQuery("from AccidentType").list(),
                sf);
    }

    public AccidentType findById(int id) {
        return transaction(session -> session.get(AccidentType.class, id), sf);
    }
}
