package lang_market.backend.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Shop getShopByIdUser(Integer id_user) {
        final String sql = "SELECT shop_name, shop_describe FROM user_langmarket WHERE id_user = ?";
        return  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id_user},
                new BeanPropertyRowMapper<>(Shop.class));
    }

    public Shop getShopByIdProduct(Integer id_product) {
        final String sql = "SELECT shop_name, shop_describe FROM user_langmarket INNER JOIN product_langmarket ON user_langmarket.id_user = product_langmarket.id_seller AND product_langmarket.id_product = ?";
        return  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id_product},
                new BeanPropertyRowMapper<>(Shop.class));
    }

    public Shop updateShop(Integer id_user, String shop_name, String shop_describe) {
        final String sql1 = "UPDATE user_langmarket SET shop_name = ?, shop_describe = ? WHERE id_user = ?";
        final String sql2 = "SELECT shop_name, shop_describe from user_langmarket WHERE id_user = ?";
        jdbcTemplate.update(sql1, shop_name, shop_describe, id_user);
        return  jdbcTemplate.queryForObject(
                sql2,
                new Object[]{id_user},
                new BeanPropertyRowMapper<>(Shop.class));
    }
}
