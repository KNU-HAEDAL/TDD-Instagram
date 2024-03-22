package haedal.tdd.instagram.service.article;

import haedal.tdd.instagram.controller.article.request.ArticleCreateRequest;
import haedal.tdd.instagram.core.exception.ResourceNotFoundException;
import haedal.tdd.instagram.entity.article.ArticleEntity;
import haedal.tdd.instagram.entity.member.MemberEntity;
import haedal.tdd.instagram.repository.article.ArticleJpaRepository;
import haedal.tdd.instagram.repository.member.MemberJpaRepository;
import haedal.tdd.instagram.service.common.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final MemberJpaRepository memberJpaRepository;
    private final ArticleJpaRepository articleJpaRepository;
    private final ImageService imageService;

    @Transactional
    public Long createArticle(Long id, ArticleCreateRequest articleCreateRequest) {
        MemberEntity member = memberJpaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", id));

        /*
          게시글 생성
         */
        ArticleEntity article = ArticleEntity.create(articleCreateRequest.content(), member);

        /*
          이미지 업로드 후
          게시글이미지 엔터티 생성
         */
        List<String> imageUrls = articleCreateRequest.imageFiles().stream()
                        .map(multipartFile -> {
                            try {
                                return imageService.uploadImage(multipartFile.getBytes());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }).toList();
        imageUrls.forEach(article::addImage);



        articleJpaRepository.save(article);
        return article.getId();
    }
}
