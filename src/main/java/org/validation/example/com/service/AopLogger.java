package org.validation.example.com.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopLogger {

    @Before("execution(* org.validation.example.com.service..*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Hello from advice method" + joinPoint);
    }

    @AfterReturning(value = "execution(* org.validation.example.com.service..*.*(..))", returning = "result")
    public void afterAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("Hello from advice after returning method" + joinPoint + " result is " + result);
    }

    @AfterThrowing(value = "execution(* org.validation.example.com.service..*.*(..))", throwing = "result")
    public void afterAdviceThrow(JoinPoint joinPoint, Throwable result) {
        System.out.println("Hello from after throwing advice method" + joinPoint + " result is " + result);
    }

    @Around(value = "execution(* org.validation.example.com.service..*.*(..))")
    public Object adviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Hello from advice around method " + joinPoint);
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Time taken to execute " + joinPoint + " is " + timeTaken);
        return proceed;
    }
}