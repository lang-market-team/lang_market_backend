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
        final String sql = "SELECT * from fee_langmarket WHERE paid_fee = true AND id_seller = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_seller},
                new BeanPropertyRowMapper<>(Fee.class));
    }

    public List<Fee> getAllUnpaidFeeOfSeller(Integer id_seller) {
        final String sql = "SELECT * from fee_langmarket WHERE paid_fee = false AND id_seller = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_seller},
                new BeanPropertyRowMapper<>(Fee.class));
    }

    public Integer createNewFee(Integer month_fee, Integer fee, Integer id_order, Integer id_seller) {
        final String sql = "INSERT INTO fee_langmarket (month_fee, fee, id_order, id_seller) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, month_fee, fee, id_order, id_seller);
    }

    public Integer payFeeForMonth(Integer month_fee, Integer id_seller) {
        final String sql = "UPDATE fee_langmarket SET paid_fee = true WHERE month_fee = ? AND id_seller = ?";
        return jdbcTemplate.update(sql, month_fee, id_seller);
    }
}
