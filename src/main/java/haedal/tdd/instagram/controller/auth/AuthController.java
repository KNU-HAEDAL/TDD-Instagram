package haedal.tdd.instagram.controller.auth;

import haedal.tdd.instagram.controller.auth.response.AccessTokenResponse;
import haedal.tdd.instagram.controller.auth.response.TokenResponse;
import haedal.tdd.instagram.controller.common.interceptor.annotation.JwtFilterExclusion;
import haedal.tdd.instagram.core.jwt.JwtProvider;
import haedal.tdd.instagram.core.jwt.JwtToken;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final JwtProvider jwtProvider;
    // private final AuthService authService;
    //1. 로그인
    @JwtFilterExclusion
    @GetMapping("/auth/login")
    public TokenResponse login(@RequestHeader("Authorization") String rawHeader) {
        String emailAndPasswordHeader = jwtProvider.parseHeader(rawHeader, false);
        byte[] bytes = Base64.getDecoder().decode(emailAndPasswordHeader);
        String emailAndPassword = new String(bytes);
        String[] emailAndPasswordArr = emailAndPassword.split(":");

        String email = emailAndPasswordArr[0];
        String password = emailAndPasswordArr[1];

        throw new RuntimeException();
//        JwtToken jwtToken = authService.login(email, password);
//        return TokenResponse.of(jwtToken);
    }

    @JwtFilterExclusion
    @PostMapping("/auth/reissue")
    public AccessTokenResponse reissue(@RequestHeader("Authorization") String refreshRawToken) {
        String refreshToken = jwtProvider.parseHeader(refreshRawToken, true);
        if(!jwtProvider.validateToken(refreshToken)) {
            throw new JwtException("유효하지 않은 토큰입니다.");
        }
        String accessToken = jwtProvider.reissueAccessToken(refreshToken);
        return AccessTokenResponse.of(accessToken);
    }
}
