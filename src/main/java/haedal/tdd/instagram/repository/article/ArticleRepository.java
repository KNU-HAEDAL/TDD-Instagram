package haedal.tdd.instagram.repository.article;

import haedal.tdd.instagram.entity.article.Article;
import haedal.tdd.instagram.entity.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByAuthor(Member member, PageRequest of);
}
