package haedal.tdd.instagram.controller.common.config;

import haedal.tdd.instagram.controller.common.interceptor.JwtInterceptor;
import haedal.tdd.instagram.controller.common.interceptor.JwtLoginResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final JwtLoginResolver jwtLoginResolver;
    private final JwtInterceptor jwtInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(jwtLoginResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * excludePath는 [JwtFilterExclusion]로 어노테이션기반으로 처리
         * @see JwtInterceptor
         */
        registry.addInterceptor(jwtInterceptor)
                .order(1)
                .addPathPatterns("/api/**");

    }
}
