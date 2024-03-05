package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    /**
     * @Timer 어노테이션이 붙은 메서드 대상
     */
    @Pointcut("@annotation(com.example.demo.annotation.Timer)")
    private void hasTimerAnnotation() {}

    @Around("hasTimerAnnotation()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 실행 전
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // method 실행
        Object result = joinPoint.proceed();

        // 실행 후
        stopWatch.stop();

        // 몇 초 걸렸는지 계산
        System.out.println("method name: " + joinPoint.getSignature().getName() + ", " + stopWatch.getTotalTimeMillis() + " milliseconds");
    }
}
