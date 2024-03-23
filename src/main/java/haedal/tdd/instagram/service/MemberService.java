package haedal.tdd.instagram.service;

import haedal.tdd.instagram.controller.common.response.PagingResponse;
import haedal.tdd.instagram.controller.member.request.MemberUpdateRequest;
import haedal.tdd.instagram.controller.member.response.MemberDto;
import haedal.tdd.instagram.controller.member.response.MemberInfoResponse;
import haedal.tdd.instagram.entity.member.Member;
import haedal.tdd.instagram.entity.member.MemberFollow;
import haedal.tdd.instagram.repository.article.ArticleRepository;
import haedal.tdd.instagram.repository.member.MemberFollowRepository;
import haedal.tdd.instagram.repository.member.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberFollowRepository memberFollowRepository;
    private final ArticleRepository articleRepository;
    @Transactional
    public void updateMember(Long memberId, MemberUpdateRequest memberUpdateRequest) {
        memberRepository.findById(memberId);
        throw new RuntimeException();
    }

    public MemberInfoResponse getMemberInfo(Long memberId) {
        memberRepository.findById(memberId);
        throw new RuntimeException();
    }

    public PagingResponse<MemberDto> getFollowerPaging(Long toMemberId, int page, int size) {
        Optional<Member> toMemberOrNull = memberRepository.findById(toMemberId);
        Page<MemberFollow> followerPage = memberFollowRepository.findByToMember(toMemberOrNull.get(), PageRequest.of(page, size));
        throw new RuntimeException();
    }

    public PagingResponse<MemberDto> getFollowingPaging(Long fromMemberId, int page, int size) {
        Optional<Member> fromMemberOrNull = memberRepository.findById(fromMemberId);
        memberFollowRepository.findByFromMember(fromMemberOrNull.get(), PageRequest.of(page, size));
        throw new RuntimeException();
    }

    public PagingResponse<String> getMyArticlePaging(Long memberId, int page, int size) {
        Optional<Member> authorOrNull = memberRepository.findById(memberId);
        articleRepository.findByAuthor(authorOrNull.get(), PageRequest.of(page, size));
        throw new RuntimeException();
    }
}
