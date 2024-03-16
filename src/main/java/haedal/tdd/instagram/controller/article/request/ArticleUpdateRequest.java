package haedal.tdd.instagram.controller.article.request;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record ArticleUpdateRequest(
        String content,
        List<MultipartFile> imageFiles //PUT : 해당 이미지로 전부 치환
) {
}
