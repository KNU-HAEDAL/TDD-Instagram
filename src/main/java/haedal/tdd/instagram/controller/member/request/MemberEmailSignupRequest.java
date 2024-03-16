package haedal.tdd.instagram.controller.member.request;

import java.time.LocalDate;

public record MemberEmailSignupRequest(
        String nickname,
        String email,
        String password,
        LocalDate birthdate
) {
}
