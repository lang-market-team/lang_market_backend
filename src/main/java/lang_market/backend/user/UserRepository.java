package lang_market.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    Integer getMaxID() {
        final String sql = "SELECT COUNT(id_user) FROM user_langmarket";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    Integer signup(Integer id_user, String username, String pass, String first_name, String last_name, String street, String town, String district, String province, String phonenumber, String email) {
        final String sql = "INSERT INTO user_langmarket (id_user, username, pass, first_name, last_name, street, town, district, province, phonenumber, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return  jdbcTemplate.update(sql, id_user, username, pass, first_name, last_name, street, town, district, province, phonenumber, email);
    }

    Integer login(String username, String pass) {
        final String sql = "SELECT COUNT(id_user) FROM user_langmarket WHERE username = ? AND pass = ?";
        return  jdbcTemplate.queryForObject(sql,new Object[]{username, pass}, Integer.class);
    }
}
