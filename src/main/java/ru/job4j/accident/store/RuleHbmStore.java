package ru.job4j.accident.store;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public class RuleHbmStore implements HbmStore {
    private final SessionFactory sf;

    public RuleHbmStore(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Rule> findAll() {
        return transaction(session -> session.createQuery("from Rule").list(),
                sf);
    }

    public Rule findById(int id) {
        return transaction(session -> session.get(Rule.class, id), sf);
    }
}
