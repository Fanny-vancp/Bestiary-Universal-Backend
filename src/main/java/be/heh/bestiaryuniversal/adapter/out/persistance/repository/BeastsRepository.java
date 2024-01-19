package be.heh.bestiaryuniversal.adapter.out.persistance.repository;

import be.heh.bestiaryuniversal.adapter.in.web.BeastValidation;
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
    public List<Beast> selectAllBeasts() {
        String sql = "SELECT * FROM beast";
        return jdbc.query(sql, new BeastRowMapper());
    }

    public List<Beast> selectBeastsByUniverse(int idUniverse){
        String sql = "SELECT Beast.*\n" +
                "FROM Beast\n" +
                "JOIN BeastUniverse ON Beast.id = BeastUniverse.beast_id\n" +
                "JOIN Universe ON BeastUniverse.universe_id = Universe.id\n" +
                "WHERE Universe.id = ?;\n";
        return jdbc.query(sql, new BeastRowMapper(), idUniverse);
    }

    public List<Beast> selectBeastsByUser(int idUser){
        String sql = "SELECT Beast.*\n" +
                "FROM Beast\n" +
                "JOIN userbeast ON Beast.id = userbeast.beast_id\n" +
                "JOIN \"User\" ON userbeast.user_id = \"User\".id\n" +
                "WHERE \"User\".id = ?;\n";
        return jdbc.query(sql, new BeastRowMapper(), idUser);
    }

    public void insertNewBeast(BeastValidation newBeast){
        String sql = "INSERT INTO beast (nom, description, img) VALUES (?, ?, ?)";
        jdbc.update(sql, newBeast.getNameBeast(),
                newBeast.getDescriptionBeast(), newBeast.getImgBeast());
        // setIDbEAST
    }

    public void insertBeastToBeastUniverse(int idBeast, int idUniverse){
        String sql = "INSERT INTO beastuniverse (beast_id, universe_id) VALUES (?, ?)";
        jdbc.update(sql, idBeast, idUniverse);
    }

    public void deleteBeastFromTheDB(int idBeast){
        String sql = "DELETE FROM beast WHERE id = ?";
        jdbc.update(sql, idBeast);
    }

    public void deleteBeastFromTheUniverse(int idBeast, int idUniverse){
        String sql = "DELETE FROM beastuniverse WHERE beast_id = ? AND universe_id = ?";
        jdbc.update(sql, idBeast, idUniverse);
    }
}
