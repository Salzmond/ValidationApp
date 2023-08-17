package org.validation.example.com.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransferAopLogger {

    @Around(value = "execution(* org.validation.example.com.service.TransferService.transfer(..))")
    public Object adviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        System.out.println("Transfer started " + joinPoint);
        try {
            proceed = joinPoint.proceed();
            System.out.println("Successful" + joinPoint);
        } catch (IllegalArgumentException ex) {
            System.out.println("Transfer error");
        }
        System.out.println("Transfer finished " + joinPoint);
        return proceed;
    }
}