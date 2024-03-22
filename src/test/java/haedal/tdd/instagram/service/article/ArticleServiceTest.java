package haedal.tdd.instagram.service.article;

import haedal.tdd.instagram.controller.article.request.ArticleCreateRequest;
import haedal.tdd.instagram.core.exception.ResourceNotFoundException;
import haedal.tdd.instagram.entity.article.ArticleEntity;
import haedal.tdd.instagram.entity.member.MemberEntity;
import haedal.tdd.instagram.repository.article.ArticleImageJpaRepository;
import haedal.tdd.instagram.repository.article.ArticleJpaRepository;
import haedal.tdd.instagram.repository.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired private ArticleService articleService;
    @Autowired private ArticleJpaRepository articleJpaRepository;
    @Autowired private MemberJpaRepository memberJpaRepository;
    @Autowired private ArticleImageJpaRepository articleImageJpaRepository;


    @AfterEach
    public void clearAll() {
        articleJpaRepository.deleteAll();
        memberJpaRepository.deleteAll();
    }

    @DisplayName("단순 텍스트를 통한 게시글 생성이 정상적으로 작동한다.")
    @Test
    void createArticleTest() {
        //given
        ArticleCreateRequest articleCreateRequest = new ArticleCreateRequest("게시글 내용", new ArrayList<>());
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


    @DisplayName("존재하지 않는 회원으로 게시글을 생성하면 예외가 발생한다.")
    @Test
    void createArticleWithNonExistingMember() {
        //given
        ArticleCreateRequest articleCreateRequest = new ArticleCreateRequest("게시글 내용", new ArrayList<>());

        //when
        assertThatThrownBy(() -> articleService.createArticle(1L, articleCreateRequest))
                .isInstanceOf(ResourceNotFoundException.class);

        //then
        assertThat(articleJpaRepository.findAll()).isEmpty();
    }


}