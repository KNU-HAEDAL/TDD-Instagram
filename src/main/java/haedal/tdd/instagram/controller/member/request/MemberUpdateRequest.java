package haedal.tdd.instagram.controller.member.request;

import java.time.LocalDate;
import org.springframework.web.multipart.MultipartFile;

public record MemberUpdateRequest(
        String nickname,
        String email,
        LocalDate birthdate,
        MultipartFile imageFile
) {
}
