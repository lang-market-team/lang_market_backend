package lang_market.backend.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("id_product={id_product}")
    @GetMapping
    public List<Comment> getAllCommentOfProduct(@PathVariable("id_product") Integer id_product) {
        return commentService.getAllCommentOfProduct(id_product);
    }

    @RequestMapping("create")
    @PostMapping
    public Integer createNewComment(@RequestBody Comment comment) {
        return commentService.createNewComment(comment);
    }
}
