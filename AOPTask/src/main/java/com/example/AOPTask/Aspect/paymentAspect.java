package com.example.AOPTask.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class paymentAspect {
    //payment
    @AfterReturning(
            pointcut = "execution(* com.example.commerce.service.paymentService.*(..))",
            returning = "result"
    )
    public void logPayment (JoinPoint joinPoint, Object result){
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        System.out.println("Notification Sent : Woh!! Payment Successfull");
        System.out.println("By the UserId" + userId);
        System.out.println("result:" + result);
        System.out.println("method:" + joinPoint.getSignature().toShortString());
    }
    @AfterThrowing(
            pointcut = "execution(* com.example.AOPTask.service.paymentService.*(..))",
            throwing = "ex"
    )
    public void logPaymentException (JoinPoint joinPoint, Exception ex){
        System.out.println("Notification Sent : Sorry!! Try again later");
        System.out.println("Exception occured while payment" + joinPoint.getSignature().toShortString());
        System.out.println("Failure Messege:" + ex.getMessage());
        System.out.println(" Payment Failed");
    }
}
