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

    public Integer createNewProduct(Integer price, String product_name, String product_describe, Integer product_type, Integer remain_amount, String product_image, Integer id_seller) {
        final String sql = "INSERT INTO product_langmarket (price, product_name, product_describe, product_type, remain_amount, product_image, id_seller) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, price, product_name, product_describe, product_type, remain_amount, product_image, id_seller);
    }

    public Product updateProduct(Integer id_product, Integer price, String product_name, String product_describe, Integer product_type, Integer remain_amount, String product_image) {
        final String sql1 = "UPDATE product_langmarket SET price = ?, product_name = ?, product_describe = ?, product_type = ?, remain_amount = ?, product_image = ? WHERE id_product = ?";
        final String sql2 = "SELECT * from product_langmarket WHERE id_product = ?";
        jdbcTemplate.update(sql1, price, product_name, product_describe, product_type, remain_amount, product_image, id_product);
        return  jdbcTemplate.queryForObject(
                sql2,
                new Object[]{id_product},
                new BeanPropertyRowMapper<>(Product.class));
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
