package haedal.tdd.instagram.entity.story;

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
@Table(name = "story")
public class StoryEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Builder
    public StoryEntity(String imageUrl, MemberEntity member) {
        this.imageUrl = imageUrl;
        this.member = member;
    }
}
