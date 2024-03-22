package haedal.tdd.instagram.entity.article;

import haedal.tdd.instagram.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "article_image")
public class ArticleImageEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @Column(nullable = false, length = 200)
    private String imageUrl;


    @Builder
    public ArticleImageEntity(ArticleEntity article, String imageUrl) {
        this.article = article;
        this.imageUrl = imageUrl;
    }

    public static ArticleImageEntity create(ArticleEntity article, String imageUrl) {
        return ArticleImageEntity.builder()
                .article(article)
                .imageUrl(imageUrl)
                .build();
    }
}
