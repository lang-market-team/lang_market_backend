package lang_market.backend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer createNewOrder(Integer total_price, Long create_time, String delivery_address, Integer id_buyer) {
        final String sql = "INSERT INTO order_langmarket (total_price, create_time, delivery_address, id_buyer) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, total_price, create_time, delivery_address, id_buyer);
    }

    public List<Order> getAllOrderOfBuyer(Integer id_buyer) {
        final String sql = "SELECT * from order_langmarket WHERE id_buyer = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_buyer},
                new BeanPropertyRowMapper<>(Order.class));
    }

    public List<OrderDetail> getDetailOfOrder(Integer id_order) {
        final String sql = "SELECT product_langmarket.id_product, product_langmarket.product_image, product_langmarket.product_name, product_langmarket.price, order_include_product.amount FROM order_include_product INNER JOIN product_langmarket ON order_include_product.id_product = product_langmarket.id_product AND order_include_product.id_order = ?;";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(OrderDetail.class));
    }

    public Order getStatusOfOrder(Integer id_order) {
        final String sql = "SELECT id_order, status_order FROM order_langmarket WHERE id_order = ?";
        return  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(Order.class));
    }

    public Order updateStatusOfOrder(Integer id_order, Integer status_order) {
        final String sql1 = "UPDATE order_langmarket SET status_order = ? WHERE id_order = ?";
        final String sql2 = "SELECT id_order, status_order FROM order_langmarket WHERE id_order = ?";
        jdbcTemplate.update(sql1, status_order, id_order);
        return  jdbcTemplate.queryForObject(
                sql2,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(Order.class));
    }
}
