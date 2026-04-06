package com.example.AOPTask.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
@Aspect
public class UserAspect {
    @AfterReturning(
            pointcut = "execution(* com.example.AOPTask.service.UserService.login(..))",
            returning = "result"
    )
    public void loginSuccess(JoinPoint jp, Object result) {

        Object[] args = jp.getArgs();
        String username = (String) args[0];
        System.out.println("LOGIN SUCCESS!!1");
        System.out.println("User:" + username);
        System.out.println("Method:" + jp.getSignature().toShortString());
        System.out.println("Timestamp:" + new Date());
        System.out.println("latets login updated");
        System.out.println("Heres ypour token");
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.AOPTask.service.UserService.login(..))",
            throwing = "ex"
    )
    public void loginFail(JoinPoint jp, Exception ex) {
        Object[] args = jp.getArgs();
        String username = (String) args[0];
        System.out.println("Failuree!!");
        System.out.println("User:" + username);
        System.out.println("Error:" + ex.getMessage());
        System.out.println("Method:" + jp.getSignature().toShortString());
        System.out.println("Timestamp:" + new Date());
        System.out.println("Failed login");
        System.out.println("Security !!!");
    }

}