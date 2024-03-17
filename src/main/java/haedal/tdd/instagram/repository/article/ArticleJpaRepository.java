package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {
}
