package haedal.tdd.instagram.entity.article;

import haedal.tdd.instagram.entity.common.BaseTimeEntity;
import haedal.tdd.instagram.entity.member.MemberEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "article")
public class ArticleEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<ArticleImageEntity> articleImages = new ArrayList<>();

    @Builder
    public ArticleEntity(String content, MemberEntity member) {
        this.content = content;
        this.member = member;
    }

    public static ArticleEntity create(String content, MemberEntity member) {
        return ArticleEntity.builder()
                .content(content)
                .member(member)
                .build();
    }

    public void addImage(String imageUrl) {
        ArticleImageEntity articleImage = ArticleImageEntity.create(this, imageUrl);
        articleImages.add(articleImage);
    }
}
