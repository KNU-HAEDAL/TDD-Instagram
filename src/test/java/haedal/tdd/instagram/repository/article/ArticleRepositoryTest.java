package haedal.tdd.instagram.repository.article;

import static org.assertj.core.api.Assertions.assertThat;

import haedal.tdd.instagram.entity.article.Article;
import haedal.tdd.instagram.entity.member.Member;
import haedal.tdd.instagram.repository.member.MemberRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@DataJpaTest //transactional 포함
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("작성자로 게시글을 페이징 조회한다.")
    void findByAuthor() {
        //given
        Member member = Member.builder()
                .nickname("jaehyeon")
                .email("fff@naver.com")
                .password("1234")
                .birthdate(LocalDate.of(2000, 11, 14))
                .build();
        //cascade활용 저장시 실제 환경과 다를 것 같아서 따로 저장
        memberRepository.save(member);

        Article article1 = Article.builder()
                .author(member)
                .content("내용1")
                .build();
        Article article2 = Article.builder()
                .author(member)
                .content("내용2")
                .build();
        Article article3 = Article.builder()
                .author(member)
                .content("내용3")
                .build();
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);
        //when
        Page<Article> articles = articleRepository
                .findByAuthor(member, PageRequest.of(0,2));

        //then
        assertThat(articles.getContent()).hasSize(2)
                .extracting("content")
                .containsExactly("내용1", "내용2");
    }
}