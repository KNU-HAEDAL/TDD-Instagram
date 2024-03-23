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
@Table(name = "comment_like", uniqueConstraints = {
        @UniqueConstraint(
                name = "comment_member_unique",
                columnNames = {"comment_id", "member_id"}
        )
})
public class CommentLikeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private CommentEntity comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Builder
    public CommentLikeEntity(CommentEntity comment, MemberEntity member) {
        this.comment = comment;
        this.member = member;
    }
}
