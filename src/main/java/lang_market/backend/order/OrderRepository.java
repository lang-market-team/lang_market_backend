package lang_market.backend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Order createNewOrder(Order order, List<OrderDetail> orderDetailList) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql1 = "INSERT INTO order_langmarket (total_price, create_time, delivery_address, paid_order, id_buyer, id_seller) VALUES (?, ?, ?, ?, ?, ?)";
        Integer total_price = 0;
        for (int i = 0; i < orderDetailList.size(); i++) {
            total_price += orderDetailList.get(i).getPrice() * orderDetailList.get(i).getAmount();
        }
        Integer finalTotal_price = total_price;
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql1, new String[] { "id_order" });
                ps.setInt(1, finalTotal_price);
                ps.setLong(2, order.getCreate_time());
                ps.setString(3, order.getDelivery_address());
                ps.setBoolean(4, order.getPaid_order());
                ps.setInt(5, order.getId_buyer());
                ps.setInt(6, order.getId_seller());
                return ps;
            }
        }, keyHolder);
        int id_order = keyHolder.getKey().intValue();
        final String sql2 = "INSERT INTO order_include_product (id_order, id_product, amount) VALUES (?, ?, ?)";
        for (int i = 0; i < orderDetailList.size(); i++) {
            Integer id_product = orderDetailList.get(i).getId_product();
            Integer amount = orderDetailList.get(i).getAmount();
            jdbcTemplate.update(sql2, id_order, id_product, amount);
        }
        return getInformationOfOrder(id_order);
    }

    public List<Order> getAllOrderOfBuyer(Integer id_buyer) {
        final String sql = "SELECT * from order_langmarket WHERE id_buyer = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_buyer},
                new BeanPropertyRowMapper<>(Order.class));
    }

    public List<Order> getAllOrderOfSeller(Integer id_seller) {
        final String sql = "SELECT * from order_langmarket WHERE id_seller = ?";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_seller},
                new BeanPropertyRowMapper<>(Order.class));
    }

    public List<OrderDetail> getDetailOfOrder(Integer id_order) {
        final String sql = "SELECT order_include_product.id_order, product_langmarket.id_product, product_langmarket.product_image, product_langmarket.product_name, product_langmarket.price, order_include_product.amount FROM order_include_product INNER JOIN product_langmarket ON order_include_product.id_product = product_langmarket.id_product AND order_include_product.id_order = ?;";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(OrderDetail.class));
    }

    public Order getInformationOfOrder(Integer id_order) {
        final String sql = "SELECT * FROM order_langmarket WHERE id_order = ?";
        return  jdbcTemplate.queryForObject(
                sql,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(Order.class));
    }

    public Order updateStatusOfOrder(Integer id_order, Integer status_order) {
        final String sql1 = "UPDATE order_langmarket SET status_order = ? WHERE id_order = ?";
        final String sql2 = "SELECT * FROM order_langmarket WHERE id_order = ?";
        jdbcTemplate.update(sql1, status_order, id_order);
        return  jdbcTemplate.queryForObject(
                sql2,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(Order.class));
    }

    public Order updateDeliveryTimeOfOrder(Integer id_order, Long delivery_time) {
        final String sql1 = "UPDATE order_langmarket SET delivery_time = ? WHERE id_order = ?";
        final String sql2 = "SELECT * FROM order_langmarket WHERE id_order = ?";
        jdbcTemplate.update(sql1, delivery_time, id_order);
        return  jdbcTemplate.queryForObject(
                sql2,
                new Object[]{id_order},
                new BeanPropertyRowMapper<>(Order.class));
    }
}
