package com.example.AOPTask.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class aspect {
    @Before("execution(* com.example.commerce.service.OrderService.*(..)")
    public void validateUser(JoinPoint joinPoint) {
        Long userId = (Long) joinPoint.getArgs()[0];
        if (userId == null) {
            throw new RuntimeException("User id invalid");
        } else {
            System.out.println("User id is validated and its id is " + userId);
        }
    }

    @Around("execution(* com.example.AOPTask.service..(..))")
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
//        Long userid=(Long) joinPoint.getArgs()[0];
//        System.out.println("Time taken : "+(end-start));
//        System.out.println("created order at "+ new Date());
        // method performance
        String methodName = joinPoint.getSignature().toShortString();
        long executionTime = end - start;
        System.out.println("method: " + methodName + "Time:" + executionTime + "Timestamp:" + new Date());
        return result;
    }
}