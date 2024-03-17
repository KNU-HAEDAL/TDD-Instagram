package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.ArticleLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleLikeJpaRepository extends JpaRepository<ArticleLikeEntity, Long> {
}
