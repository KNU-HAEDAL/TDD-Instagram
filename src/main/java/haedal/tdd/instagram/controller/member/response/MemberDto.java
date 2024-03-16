package haedal.tdd.instagram.controller.member.response;

//팔로워, 팔로잉 상세조회에 쓰이는 DTO
public record MemberDto(
        Long memberId,
        String nickname,
        String profileImageUrl
) {
}