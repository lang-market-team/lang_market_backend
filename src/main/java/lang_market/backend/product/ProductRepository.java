package lang_market.backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getAllProduct() {
        final String sql = "SELECT * from product_langmarket";
        return  jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Product.class));
    }

    public Product getOneProduct(Integer id_product) {
        final String sql = "SELECT * from product_langmarket where id_product = ?";
        return  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id_product},
                new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getProductByType(Integer product_type) {
        final String sql = "SELECT * from product_langmarket where product_type = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{product_type},
                new BeanPropertyRowMapper<>(Product.class));
    }
}
