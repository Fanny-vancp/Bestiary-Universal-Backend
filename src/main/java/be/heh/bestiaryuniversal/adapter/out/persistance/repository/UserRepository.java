package be.heh.bestiaryuniversal.adapter.out.persistance.repository;

import be.heh.bestiaryuniversal.adapter.in.web.UserValidation;
import be.heh.bestiaryuniversal.application.domain.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    // attributes
    private final JdbcTemplate jdbc;

    // constructor
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // methods
    public List<User> selectAllUser() {
        String sql = "SELECT * FROM \"User\"";
        return jdbc.query(sql, new UserRowMapper());
    }

    public void insertNewUser(UserValidation newUser){
        String sql = "INSERT INTO \"User\" (firstname, lastname, login, email, password) VALUES (?, ?, ?,?,?)";
        jdbc.update(sql, newUser.getFirstNameUser(),
                newUser.getLastNameUser(), newUser.getLoginUser(),
                newUser.getEmailUser(), newUser.getPasswordUser());
        // setIDbEAST
    }

    public void deleteUserFromTheDB(int idUser){
        String sql = "DELETE FROM \"User\" WHERE id = ?";
        jdbc.update(sql, idUser);
    }
}
