package lang_market.backend.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Comment> getAllCommentOfProduct(Integer id_product) {
        final String sql = "SELECT first_name, last_name, content_comment, time_create, rating_comment FROM comment_langmarket INNER JOIN user_langmarket ON comment_langmarket.id_buyer = user_langmarket.id_user AND comment_langmarket.id_product = ?;";
        return  jdbcTemplate.query(
                sql,
                new Object[]{id_product},
                new BeanPropertyRowMapper<>(Comment.class));
    }

    public Integer createNewComment(Integer id_product, Integer id_buyer, String content_comment, Long time_create, Double rating_comment) {
        final String sql1 = "INSERT INTO comment_langmarket (id_product, id_buyer, content_comment, time_create, rating_comment) VALUES (?, ?, ?, ?, ?)";
        final String sql2 = "SELECT rating_comment FROM comment_langmarket WHERE id_product = ?";
        final String sql3 = "UPDATE product_langmarket SET rating = ? WHERE id_product = ?";
        jdbcTemplate.update(sql1, id_product, id_buyer, content_comment, time_create, rating_comment);
        List<Comment> ratingList = jdbcTemplate.query(
                sql2,
                new Object[]{id_product},
                new BeanPropertyRowMapper<>(Comment.class));
        Double newRating = 0.0;
        for (int i = 0; i < ratingList.size(); i++) {
            newRating += ratingList.get(i).getRating_comment();
        }
        newRating = newRating/ratingList.size();
        return  jdbcTemplate.update(sql3,newRating, id_product);
    }
}
