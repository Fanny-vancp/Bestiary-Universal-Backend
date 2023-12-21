package be.heh.bestiaryuniversal.adapter.out.persistance.repository;

import be.heh.bestiaryuniversal.application.domain.model.Universe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.sql.ResultSet;

public class UniverseRowMapper implements RowMapper<Universe> {
    @Override
    public Universe mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Universe(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("img")
        );
    }

}
