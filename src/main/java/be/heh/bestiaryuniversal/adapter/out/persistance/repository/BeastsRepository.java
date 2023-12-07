package be.heh.bestiaryuniversal.adapter.out.persistance.repository;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BeastsRepository {
    // attributes
    private final JdbcTemplate jdbc;

    // constructor
    public BeastsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // methods
    public List<Beast> findAllBeasts() {
        String sql = "SELECT * FROM Beast";
        return jdbc.query(sql, new BeastRowMapper());
    }
}
