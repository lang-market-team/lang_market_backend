package lang_market.backend.fee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Fee> getAllPaidFee() {
        final String sql = "SELECT * from fee_langmarket WHERE paid_fee = true";
        return  jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Fee.class));
    }

    public List<Fee> getAllUnpaidFee() {
        final String sql = "SELECT * from fee_langmarket WHERE paid_fee = false";
        return  jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Fee.class));
    }

    public List<Fee> getAllPaidFeeOfSeller(Integer id_seller) {
        final String sql = "SELECT * from order_langmarket WHERE id_buyer = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_seller},
                new BeanPropertyRowMapper<>(Fee.class));
    }
}
