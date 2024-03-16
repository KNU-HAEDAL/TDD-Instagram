package haedal.tdd.instagram.controller.article.response;

import haedal.tdd.instagram.controller.member.response.MemberDto;
import java.util.List;

public record ArticleDto(
        Long articleId,
        String content,
        int likeCount,
        int commentCount,
        List<String> imageUrls,
        MemberDto author
) {
}
