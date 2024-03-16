package haedal.tdd.instagram.controller.member.response;

import java.time.LocalDate;

public record MemberInfoResponse(
        int follwer,
        int following,
        String nickname,
        String email,
        LocalDate birthdate,
        String profileImageUrl
) {
}
