package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleImageRepository extends JpaRepository<ArticleImage, Long> {
}
