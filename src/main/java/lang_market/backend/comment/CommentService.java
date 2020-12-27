package lang_market.backend.comment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllCommentOfProduct(Integer id_product) {
        return commentRepository.getAllCommentOfProduct(id_product);
    }

    public Integer createNewComment(Comment comment) {
        return commentRepository.createNewComment(comment.id_product, comment.id_buyer, comment.content_comment, comment.getTime_create(), comment.getRating_comment());
    }
}
