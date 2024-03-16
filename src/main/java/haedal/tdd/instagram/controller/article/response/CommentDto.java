package haedal.tdd.instagram.controller.article.response;

import haedal.tdd.instagram.controller.member.response.MemberDto;
import java.time.LocalDateTime;

public record CommentDto(
        Long commentId,
        String content,
        MemberDto commenter,
        LocalDateTime createdAt
) {
}
