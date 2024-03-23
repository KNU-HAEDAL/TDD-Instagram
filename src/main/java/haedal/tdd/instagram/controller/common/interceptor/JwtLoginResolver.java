package haedal.tdd.instagram.controller.common.interceptor;

import haedal.tdd.instagram.controller.common.interceptor.annotation.Login;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * [JwtInterceptor]에서 넣어준 [memberId]를
 * 컨트롤러의 메서드의 파라미터로 넣어주는 Resolver.
 * <p>
 * 컨트롤러에서 매개변수에 (@Login Long memberId)로 사용한다
 * @see JwtInterceptor
 * @see Login
 */
@Component
public class JwtLoginResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Login.class)
                && parameter.getParameterType().equals(Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return webRequest.getAttribute("memberId", NativeWebRequest.SCOPE_REQUEST);
    }
}
