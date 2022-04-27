package ru.job4j.accident.store;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
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
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

    public Rule getById(int id) {
        return jdbc.queryForObject(
                "select * from rule where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Rule(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
        );
    }
}
