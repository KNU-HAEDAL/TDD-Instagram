package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.ArticleLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long> {
}
