package haedal.tdd.instagram.repository.member;

import haedal.tdd.instagram.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
