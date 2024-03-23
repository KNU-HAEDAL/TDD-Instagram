package haedal.tdd.instagram.core.jwt;

import lombok.Builder;
import lombok.Getter;

@Builder
public record JwtToken(
        String accessToken,
        String refreshToken
) {
}
