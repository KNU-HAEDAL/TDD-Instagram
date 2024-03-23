package haedal.tdd.instagram.repository.comment;

import haedal.tdd.instagram.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
