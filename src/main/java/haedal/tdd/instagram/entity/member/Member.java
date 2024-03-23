package haedal.tdd.instagram.entity.member;

import haedal.tdd.instagram.entity.article.Article;
import haedal.tdd.instagram.entity.common.BaseTimeEntity;
import haedal.tdd.instagram.entity.story.Story;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseTimeEntity {
    @Id @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50)
    private String facebookId;

    @Column(nullable = false)
    private LocalDate birthdate;

    private String profileImageUrl;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Story> stories = new ArrayList<>();

    @Builder
    public Member(String nickname, String email, String password, String facebookId, LocalDate birthdate, String profileImageUrl) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.facebookId = facebookId;
        this.birthdate = birthdate;
        this.profileImageUrl = profileImageUrl;
    }
}
