package haedal.tdd.instagram.controller.member;

import haedal.tdd.instagram.controller.common.response.PagingResponse;
import haedal.tdd.instagram.controller.member.request.MemberEmailSignupRequest;
import haedal.tdd.instagram.controller.member.request.MemberUpdateRequest;
import haedal.tdd.instagram.controller.member.response.MemberDto;
import haedal.tdd.instagram.controller.member.response.MemberInfoResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    //1. 회원가입
    @PostMapping("/member/email-signup")
    public void emailSignup(@RequestBody MemberEmailSignupRequest memberEmailSignupRequest){
        throw new RuntimeException();
    }
    //2. 회원탈퇴
    @DeleteMapping("/member")
    public void deleteMember(){
        throw new RuntimeException();
    }

    //3. 정보수정
    @PutMapping("/member")
    public void updateMember(@RequestBody MemberUpdateRequest memberUpdateRequest){
        throw new RuntimeException();
    }

    //4. 내 정보 확인 (팔로워 숫자 + 개인정보)
    @GetMapping("/member")
    public MemberInfoResponse getMyInfo(){
        throw new RuntimeException();
    }

    //5. 팔로워 상세조회 페이징 : MemberDto 사용
    @GetMapping("/member/follower")
    public PagingResponse<MemberDto> getFollowerPaging(int page, int size){
        throw new RuntimeException();
    }

    //6. 팔로잉 상세조회 페이징 : MemberDto 사용
    @GetMapping("/member/following")
    public PagingResponse<MemberDto> getFollowingPaging(int page, int size){
        throw new RuntimeException();
    }

    //7. 내 게시글 확인 (사진만 페이징) : List<String>으로 imageUrl
    @GetMapping("/member/article")
    public PagingResponse<String> getMyArticlePaging(int page, int size){
        throw new RuntimeException();
    }
}

//8. 내 스토리 확인 (우선순위2)