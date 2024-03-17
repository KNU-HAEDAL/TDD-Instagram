package haedal.tdd.instagram.entity.member;


import haedal.tdd.instagram.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member_follow", uniqueConstraints = {
        @UniqueConstraint(
                name = "member_follow_uk",
                columnNames = {"following", "followed"}
        )
})
public class MemberFollowEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following")
    private MemberEntity followingMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed")
    private MemberEntity followedMember;

    @Builder
    public MemberFollowEntity(MemberEntity followingMember, MemberEntity followedMember) {
        this.followingMember = followingMember;
        this.followedMember = followedMember;
    }
}
