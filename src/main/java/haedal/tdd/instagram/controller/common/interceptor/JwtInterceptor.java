package haedal.tdd.instagram.controller.common.interceptor;

import haedal.tdd.instagram.controller.common.interceptor.annotation.JwtFilterExclusion;
import haedal.tdd.instagram.core.jwt.JwtProvider;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * [Authorization] 헤더에서 토큰을 추출한뒤 유효성을 검사한다.
 * <p>
 * 유효한 토큰이면 [memberId]를 request에 넣어준다.
 * <p>
 * 이후 [JwtLoginResolver]에서 [memberId]를 컨트롤러의 매개변수로 넣어준다.
 *
 * @see JwtLoginResolver
 */
@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {
    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean checkJwtFilter = checkAnnotation(handler, JwtFilterExclusion.class);
        if (checkJwtFilter) return true;

        String rawToken = request.getHeader("Authorization");
        String token = jwtProvider.parseHeader(rawToken, true);
        if (!jwtProvider.validateToken(token)) {
            throw new JwtException("유효하지 않은 토큰입니다.");
        }

        Long memberId = jwtProvider.extractMemberId(token);


        request.setAttribute("memberId", memberId);
        return true;
    }


    /**
     * [clazz] 어노테이션이 있는지 확인한다.
     */
    private boolean checkAnnotation(Object handler, Class clazz) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        return handlerMethod.getMethodAnnotation(clazz) != null;
    }
}
