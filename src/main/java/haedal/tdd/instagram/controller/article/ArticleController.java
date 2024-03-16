package haedal.tdd.instagram.controller.article;

import haedal.tdd.instagram.controller.article.request.ArticleCreateRequest;
import haedal.tdd.instagram.controller.article.response.ArticleDto;
import haedal.tdd.instagram.controller.common.response.PagingResponse;
import haedal.tdd.instagram.controller.member.response.MemberDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ArticleController {
    //1. 게시글 조회 (페이징, 최신순)
    @GetMapping("/articles")
    public PagingResponse<ArticleDto> getArticles(int page, int size){
        throw new RuntimeException();
    }
    //2. 게시글 생성
    @PostMapping("/article")
    public Long createArticle(@RequestBody ArticleCreateRequest articleCreateRequest){
        throw new RuntimeException();
    }

    //3. 게시글 수정
    @PutMapping("/article/{articleId}")
    public void updateArticle(Long articleId, @RequestBody ArticleCreateRequest articleCreateRequest){
        throw new RuntimeException();
    }


    //4. 게시글 삭제
    @DeleteMapping("/article/{articleId}")
    public void deleteArticle(Long articleId){
        throw new RuntimeException();
    }

    //5. 게시글 좋아요한 사람 조회
    @GetMapping("/article/{articleId}/like")
    public PagingResponse<MemberDto> getLikeArticlePaging(int page, int size){
        throw new RuntimeException();
    }

    //6. 게시글 좋아요 누르기
    @PostMapping("/article/{articleId}/like")
    public void likeArticle(Long articleId){
        throw new RuntimeException();
    }

}
