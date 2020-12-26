package lang_market.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer howManyUser() {
        final String sql = "SELECT COUNT(id_user) FROM user_langmarket";
        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }

    public Integer signup(String username, String pass, String first_name, String last_name, String street, String town, String district, String province, String phonenumber, String email, Integer type_account, String shop_name, String shop_describe) {
        final String sql = "INSERT INTO user_langmarket (username, pass, first_name, last_name, street, town, district, province, phonenumber, email, type_account, shop_name, shop_describe) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return  jdbcTemplate.update(sql, username, pass, first_name, last_name, street, town, district, province, phonenumber, email, type_account, shop_name, shop_describe);
    }

    public User login(String username, String pass) {
        final String sql = "SELECT id_user, first_name, last_name, type_account FROM user_langmarket WHERE username = ? AND pass = ?";
        return  jdbcTemplate.queryForObject(
                sql,
                new Object[]{username, pass},
                new BeanPropertyRowMapper<>(User.class));
    }
}
