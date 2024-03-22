package haedal.tdd.instagram.service.article;

import haedal.tdd.instagram.controller.article.request.ArticleCreateRequest;
import haedal.tdd.instagram.entity.article.ArticleEntity;
import haedal.tdd.instagram.entity.member.MemberEntity;
import haedal.tdd.instagram.repository.article.ArticleJpaRepository;
import haedal.tdd.instagram.repository.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class ArticleServiceTest {
    private final ArticleService articleService;
    private final ArticleJpaRepository articleJpaRepository;
    private final MemberJpaRepository memberJpaRepository;


    @DisplayName("게시글 생성이 정상적으로 작동한다.")
    @Test
    void createArticleTest() {
        //given
        ArticleCreateRequest articleCreateRequest = new ArticleCreateRequest("게시글 내용", null);
        MemberEntity member = MemberEntity.builder()
                .nickname("닉네임")
                .email("asd@naver.com")
                .birthDate(LocalDate.of(2024, 1, 1))
                .build();
        memberJpaRepository.save(member);


        //when
        Long id = articleService.createArticle(member.getId(), articleCreateRequest);

        //then
        ArticleEntity createdArticle = articleJpaRepository.findAll().get(0);
        assertThat(articleJpaRepository.findAll()).hasSize(1);
        assertThat(createdArticle).isNotNull();
        assertThat(createdArticle.getContent()).isEqualTo("게시글 내용");
        assertThat(createdArticle.getMember().getId()).isEqualTo(member.getId());
        assertThat(createdArticle.getId()).isEqualTo(id);
    }


}