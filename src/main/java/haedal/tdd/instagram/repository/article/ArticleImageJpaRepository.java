package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.ArticleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleImageJpaRepository extends JpaRepository<ArticleImageEntity, Long> {
}
