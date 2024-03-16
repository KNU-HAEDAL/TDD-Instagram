package haedal.tdd.instagram.controller.article.request;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record ArticleCreateRequest(
        String content,
        List<MultipartFile> imageFiles
) {
}
