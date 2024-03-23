package haedal.tdd.instagram.repository.member;

import haedal.tdd.instagram.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
