package haedal.tdd.instagram.repository.member;

import haedal.tdd.instagram.entity.member.Member;
import haedal.tdd.instagram.entity.member.MemberFollow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFollowRepository extends JpaRepository<MemberFollow, Long> {
    Page<MemberFollow> findByToMember(Member toMember, PageRequest of);
    Page<MemberFollow> findByFromMember(Member fromMember, PageRequest of);

}
