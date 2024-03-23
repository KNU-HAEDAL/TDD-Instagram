package haedal.tdd.instagram.repository.comment;

import haedal.tdd.instagram.entity.comment.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
}
