package ru.job4j.accident.store;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void add(Accident accident) {
        jdbc.update("insert into accident (name, text, address) values (?, ?, ?)",
                accident.getName(), accident.getText(), accident.getAddress());
    }

    public List<Accident> findAll() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }

    public Accident findById(int id) {
        return jdbc.queryForObject(
                "select * from accident where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Accident(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("text"),
                                rs.getString("address")
                        )
        );
    }

    public void update(Accident accident) {
        jdbc.update("update accident set name = ?, text = ?, address = ? where id = ?",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getId());

    }
}
