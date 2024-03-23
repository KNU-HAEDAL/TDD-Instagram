package haedal.tdd.instagram.controller.auth.response;

import haedal.tdd.instagram.core.jwt.JwtToken;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;

    public static TokenResponse of(JwtToken jwtToken) {
        return TokenResponse.builder()
                .accessToken(jwtToken.accessToken())
                .refreshToken(jwtToken.refreshToken())
                .build();
    }
}
