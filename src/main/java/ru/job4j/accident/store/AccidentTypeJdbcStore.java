package ru.job4j.accident.store;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public class AccidentTypeJdbcStore {
    private final JdbcTemplate jdbc;

    public AccidentTypeJdbcStore(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<AccidentType> findAll() {
        return jdbc.query("select id, name from accident_type",
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));
                    return type;
                });
    }

    public AccidentType getById(int id) {
        return jdbc.queryForObject(
                "select * from accident_type where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new AccidentType(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
        );
    }
}
