package ru.job4j.accident.store;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void add(Accident accident) {
        accident.setId(jdbc.update(
                "insert into accident (name, text, address, type_id) values (?, ?, ?, ?) returning id",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getType().getId()));
        updateAccidentRuleTable(accident);
    }

    public List<Accident> findAll() {
        return jdbc.query("select "
                        + "a.id as id, a.name as name, text, address, t.id as t_id, t.name as t_name "
                        + "from accident a join accident_type t on a.type_id = t.id",
                new AccidentMapper());
    }

    public Accident findById(int id) {
        return jdbc.queryForObject(
                "select * from accident a "
                        + "join accident_type t on a.type_id = t.id where a.id = ?",
                new Object[]{id}, new AccidentMapper()
        );
    }

    public void update(Accident accident) {
        jdbc.update(
                "update accident set name = ?, text = ?, address = ?, type_id = ? where id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getType().getId(),
                accident.getId());
        jdbc.update("delete from accident_rule where accident_id = ?", accident.getId());
        updateAccidentRuleTable(accident);
    }

    private void updateAccidentRuleTable(Accident accident) {
        for (Rule rule : accident.getRules()) {
            jdbc.update("insert into accident_rule(accident_id, rule_id) values (?, ?)",
                    accident.getId(), rule.getId());
        }
    }

    private class AccidentMapper implements RowMapper<Accident> {

        @Override
        public Accident mapRow(ResultSet rs, int i) throws SQLException {
            Accident accident = new Accident(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("text"),
                    rs.getString("address"),
                    new AccidentType(
                            rs.getInt("t_id"),
                            rs.getString("t_name"))
            );
            accident.setRules(Set.copyOf(
                    jdbc.query(
                            "select r.id as id, r.name as name from accident_rule ar "
                                    + "join rule r on r.id = ar.rule_id "
                                    + "where ar.accident_id = ?",
                            new Object[]{accident.getId()},
                            new BeanPropertyRowMapper(Rule.class)
                    ))
            );
            return accident;
        }
    }
}
