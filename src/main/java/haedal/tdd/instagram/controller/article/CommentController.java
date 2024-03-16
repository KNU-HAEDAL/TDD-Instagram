package haedal.tdd.instagram.controller.article;

import haedal.tdd.instagram.controller.article.request.CommentCreateRequest;
import haedal.tdd.instagram.controller.article.request.CommentUpdateRequest;
import haedal.tdd.instagram.controller.article.response.CommentDto;
import haedal.tdd.instagram.controller.common.response.PagingResponse;
import javax.xml.stream.events.Comment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    //1. 특정 게시글 댓글 생성
    @PostMapping("/comment")
    public Long createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        throw new RuntimeException();
    }

    //2. 특정 게시글 댓글 조회
    @GetMapping("/article/{articleId}/comment")
    public PagingResponse<CommentDto> getCommentPaging(int page, int size){
        throw new RuntimeException();
    }

    //3. 특정 게시글 댓글 수정
    @PutMapping("/comment/{commentId}")
    public void updateComment(Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        throw new RuntimeException();
    }

    //4. 특정 게시글 댓글 삭제
    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(Long commentId){
        throw new RuntimeException();
    }

    //5. 댓글 좋아요 누르기(취소도 가능)
    @PostMapping("/comment/{commentId}/like")
    public void likeComment(Long commentId){
        throw new RuntimeException();
    }

    //6. 댓글 좋아요 목록 조회 (페이징)
    @GetMapping("/comment/{commentId}/like")
    public PagingResponse<CommentDto> getLikeCommentPaging(int page, int size){
        throw new RuntimeException();
    }
}
