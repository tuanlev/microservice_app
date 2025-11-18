package com.tuan.authservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggerAspect {
    @Around("execution(* com.tuan.authservice.*.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("entering around: "  + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
