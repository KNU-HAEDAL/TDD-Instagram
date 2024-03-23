package haedal.tdd.instagram.entity.article;

import haedal.tdd.instagram.entity.common.BaseTimeEntity;
import haedal.tdd.instagram.entity.member.MemberEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "article_like", uniqueConstraints = {
        @UniqueConstraint(
                name = "article_member_unique",
                columnNames = {"article_id", "member_id"}
        )
} )
public class ArticleLikeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Builder
    public ArticleLikeEntity(ArticleEntity article, MemberEntity member) {
        this.article = article;
        this.member = member;
    }

}
