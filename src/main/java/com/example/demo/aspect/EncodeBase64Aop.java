package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Base64.Encoder;

@Aspect
@Component
public class EncodeBase64Aop {

    /**
     * classes 패키지 하위의 *Controller 클래스의 모든 메서드가 대상
     */
    @Pointcut("execution(* com.example.demo.classes.*Controller.*(..))")
    private void pointcut() {}

    /**
     * @EncodeBase64 어노테이션이 붙은 메서드 대상
     */
    @Pointcut("@annotation(com.example.demo.annotation.EncodeBase64)")
    private void hasEncodeAnnotation() {}

    @Around("pointcut() && hasEncodeAnnotation()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Encoder encode = Base64.getEncoder();

        //메서드로 들어오는 매개변수들
        Object[] args = joinPoint.getArgs();

        int index = 0;
        for(Object arg : args) {
            // String 매개변수일 경우 암호화
            if (arg instanceof String) {
                args[index] = new String(encode.encode(((String) arg).getBytes()));
            }
            index++;
        }

        return joinPoint.proceed(args);
    }
}
