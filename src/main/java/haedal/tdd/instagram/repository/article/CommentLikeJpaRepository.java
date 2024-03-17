package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.CommentLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeJpaRepository extends JpaRepository<CommentLikeEntity, Long> {
}
