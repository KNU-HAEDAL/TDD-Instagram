package haedal.tdd.instagram.controller.article;

import haedal.tdd.instagram.controller.article.request.CommentCreateRequest;
import haedal.tdd.instagram.controller.article.request.CommentUpdateRequest;
import haedal.tdd.instagram.controller.article.response.CommentDto;
import haedal.tdd.instagram.controller.common.interceptor.annotation.Login;
import haedal.tdd.instagram.controller.common.response.PagingResponse;
import javax.xml.stream.events.Comment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    //1. 특정 게시글 댓글 생성
    @PostMapping("/comment")
    public Long createComment(@Login Long userId, @RequestBody CommentCreateRequest commentCreateRequest){
        throw new RuntimeException();
    }

    //2. 특정 게시글 댓글 조회
    @GetMapping("/article/{articleId}/comment")
    public PagingResponse<CommentDto> getCommentPaging(@Login Long userId, @PathVariable Long articleId, int page, int size){
        throw new RuntimeException();
    }

    //3. 특정 게시글 댓글 수정
    @PutMapping("/comment/{commentId}")
    public void updateComment(@Login Long userId, @PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        throw new RuntimeException();
    }

    //4. 특정 게시글 댓글 삭제
    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@Login Long userId, @PathVariable Long commentId){
        throw new RuntimeException();
    }

    //5. 댓글 좋아요 누르기(취소도 가능)
    @PostMapping("/comment/{commentId}/like")
    public void likeComment(@Login Long userId, @PathVariable Long commentId){
        throw new RuntimeException();
    }

    //6. 댓글 좋아요 목록 조회 (페이징)
    @GetMapping("/comment/{commentId}/like")
    public PagingResponse<CommentDto> getLikeCommentPaging(@Login Long userId, @PathVariable Long commentId,int page, int size){
        throw new RuntimeException();
    }
}
