package be.heh.bestiaryuniversal.adapter.out.persistance.repository;

import be.heh.bestiaryuniversal.application.domain.model.Beast;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeastRowMapper implements RowMapper<Beast> {
    @Override
    public Beast mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Beast(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getString("img"));
    }
}
