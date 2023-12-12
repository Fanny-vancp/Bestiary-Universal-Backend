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

    public List<Beast> findBeastsByUniverse(int idUniverse){
        String sql = "SELECT Beast.*\n" +
                "FROM Beast\n" +
                "JOIN BeastUniverse ON Beast.id = BeastUniverse.beast_id\n" +
                "JOIN Universe ON BeastUniverse.universe_id = Universe.id\n" +
                "WHERE Universe.id = ?;\n";
        return jdbc.query(sql, new BeastRowMapper(), idUniverse);
    }
}
