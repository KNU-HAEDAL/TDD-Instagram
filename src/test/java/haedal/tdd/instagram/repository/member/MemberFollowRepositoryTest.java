package haedal.tdd.instagram.repository.member;

import static org.assertj.core.api.Assertions.assertThat;

import haedal.tdd.instagram.entity.member.Member;
import haedal.tdd.instagram.entity.member.MemberFollow;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
class MemberFollowRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberFollowRepository memberFollowRepository;

//    @BeforeAll
//    void setUp() {
//      왜 static으로만 써야 하는지 찾아볼 것
//    }

    @Test
    @DisplayName("특정 멤버의 팔로워 정보를 페이징 조회한다")
    void findFollowers() {
        //given
        Member member1 = createMember("jaehyeon1", "fff1@naver.com","1111", LocalDate.of(2000, 11, 14));
        Member member2 = createMember("jaehyeon2", "fff2@naver.com","2222", LocalDate.of(2000, 11, 14));
        Member member3 = createMember("jaehyeon3", "fff3@naver.com","3333", LocalDate.of(2000, 11, 14));
        memberRepository.saveAll(List.of(member1, member2, member3));

        MemberFollow memberFollow1 = createFollow(member1, member2);
        MemberFollow memberFollow2 = createFollow(member1, member3);
        MemberFollow memberFollow3 = createFollow(member2, member1);
        memberFollowRepository.saveAll(List.of(memberFollow1, memberFollow2, memberFollow3));

        //when
        Page<MemberFollow> followersOfMember1 = memberFollowRepository.findByToMember(member1, PageRequest.of(0, 2));

        //then
        assertThat(followersOfMember1).hasSize(1)
                .extracting("fromMember.nickname")
                .containsExactly("jaehyeon2");
    }

    @Test
    @DisplayName("특정 멤버의 팔로잉 정보를 페이징 조회한다.")
    void findFollowings() {
        //given
        Member member1 = createMember("jaehyeon1", "fff1@naver.com","1111", LocalDate.of(2000, 11, 14));
        Member member2 = createMember("jaehyeon2", "fff2@naver.com","2222", LocalDate.of(2000, 11, 14));
        Member member3 = createMember("jaehyeon3", "fff3@naver.com","3333", LocalDate.of(2000, 11, 14));
        memberRepository.saveAll(List.of(member1, member2, member3));

        MemberFollow memberFollow1 = createFollow(member1, member2);
        MemberFollow memberFollow2 = createFollow(member1, member3);
        MemberFollow memberFollow3 = createFollow(member2, member1);
        memberFollowRepository.saveAll(List.of(memberFollow1, memberFollow2, memberFollow3));

        //when
        Page<MemberFollow> followingsOfMember1 = memberFollowRepository.findByFromMember(member1, PageRequest.of(0, 2));

        //then
        assertThat(followingsOfMember1).hasSize(2)
                .extracting("toMember.nickname")
                .containsExactly("jaehyeon2", "jaehyeon3");
    }

    private Member createMember(String nickname, String email, String password, LocalDate birthdate) {
        return Member.builder()
                .nickname(nickname)
                .email(email)
                .password(password)
                .birthdate(birthdate)
                .build();
    }

    private MemberFollow createFollow(Member from, Member to) {
        return MemberFollow.builder()
                .fromMember(from)
                .toMember(to)
                .build();
        }
}