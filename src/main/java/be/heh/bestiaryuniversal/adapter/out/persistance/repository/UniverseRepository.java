package be.heh.bestiaryuniversal.adapter.out.persistance.repository;

import be.heh.bestiaryuniversal.adapter.in.web.UniverseValidation;
import be.heh.bestiaryuniversal.application.domain.model.Universe;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UniverseRepository {
    private final JdbcTemplate jdbc;
    public UniverseRepository(JdbcTemplate jdbc) {this.jdbc = jdbc; }

    public List<Universe> selectAllUniverses() {
        String sql = "SELECT * FROM universe";
        return jdbc.query(sql, new UniverseRowMapper());
    }

    public void insertNewUniverse(UniverseValidation newUniverse) {
        String sql = "INSERT INTO universe (nom, img) VALUES (?, ?)";
        jdbc.update(sql, newUniverse.getNameUniverse(), newUniverse.getImgUniverse());
    }

    public void deleteUniverseFromTheDB(int idUniverse) {
        String sql = "DELETE FROM universe WHERE id = ?";
        jdbc.update(sql, idUniverse);
    }
}
