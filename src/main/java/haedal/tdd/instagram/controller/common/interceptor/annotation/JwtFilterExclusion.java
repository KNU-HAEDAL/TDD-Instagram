package haedal.tdd.instagram.controller.common.interceptor.annotation;


import haedal.tdd.instagram.controller.common.interceptor.JwtInterceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * [JwtInterceptor]에서 제외할 컨트롤러의 메서드에 붙이는 어노테이션
 * @see JwtInterceptor
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtFilterExclusion {
}
