package haedal.tdd.instagram.controller.common.interceptor.annotation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interceptor에서 얻은 MemberId를 Controller에 주입해주기위한 어노테이션
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Login {
}
