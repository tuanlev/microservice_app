package com.tuan.apigateway.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggerAspect {
    @Around("execution(* com.tuan.apigateway.*.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("entering around: "  + joinPoint.getSignature().getName());
        try {
            Object result = joinPoint.proceed();
            return result;
        } catch (Throwable throwable) {
            log.error("around exception "+joinPoint.getSignature().getName()+": " + throwable.getMessage());
            throw throwable;
        }
    }
}
