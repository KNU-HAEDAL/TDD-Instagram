package haedal.tdd.instagram.repository.member;

import haedal.tdd.instagram.entity.member.MemberFollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFollowJpaRepository extends JpaRepository<MemberFollowEntity, Long> {
}
