package haedal.tdd.instagram.repository.member;

import haedal.tdd.instagram.entity.member.MemberFollow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFollowRepository extends JpaRepository<MemberFollow, Long> {
}
