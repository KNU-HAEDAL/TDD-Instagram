package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
