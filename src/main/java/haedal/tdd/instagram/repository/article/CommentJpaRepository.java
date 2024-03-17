package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<CommentEntity, Long> {
}
