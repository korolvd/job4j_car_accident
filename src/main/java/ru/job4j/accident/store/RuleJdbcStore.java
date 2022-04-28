package ru.job4j.accident.store;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public class RuleJdbcStore {
    private final JdbcTemplate jdbc;

    public RuleJdbcStore(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Rule> findAll() {
        return jdbc.query("select id, name from rule",
                new BeanPropertyRowMapper<>(Rule.class));
    }

    public Rule getById(int id) {
        return jdbc.queryForObject(
                "select * from rule where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Rule.class)
        );
    }
}
