package haedal.tdd.instagram.entity.member;

import haedal.tdd.instagram.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class MemberEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(unique = true, length = 50)
    private String facebookId;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(length = 200)
    private String profileImageUrl;

    @Builder
    public MemberEntity(String nickname, String email, String password, String facebookId, LocalDate birthDate, String profileImageUrl) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.facebookId = facebookId;
        this.birthDate = birthDate;
        this.profileImageUrl = profileImageUrl;
    }
}
