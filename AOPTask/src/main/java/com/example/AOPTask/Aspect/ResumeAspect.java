package com.example.AOPTask.Aspect;

import com.example.AOPTask.entity.Resume;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ResumeAspect {
    @AfterReturning(
            pointcut = "execution(* com.example.AOPTask.service.resumeService.uploadResume(..))",
            returning = "result"
    )
    public void resumeUploadSuccess(JoinPoint jp, Object result) {

        Resume resume = (Resume) jp.getArgs()[0];
        System.out.println("Uploaded Successfully");
        System.out.println("Name:" +resume.getName());
        System.out.println("Email:" + resume.getEmail());
        System.out.println("Phone:" + resume.getPhone());
        System.out.println("Method name:"+jp.getSignature().getName());
        System.out.println("Timestamp:" + new Date());

        System.out.println("OverAll:Upload Successfull!!!");
    }
    @AfterThrowing(
            pointcut = "execution(* com.example.ecommerce.service.ResumeService.uploadResume(..))",
            throwing = "ex"
    )
    public void resumeUploadFailure(JoinPoint jp, Exception ex) {
        Resume resume = (Resume) jp.getArgs()[0];
        System.out.println("Uploaded Failure");
        System.out.println("Name:" +resume.getName());
        System.out.println("Error:" + ex.getMessage());
        System.out.println("Method name:"+jp.getSignature().getName());
        System.out.println("Timestamp:" + new Date());
        System.out.println("Overview: Upload Failure!1 Please try once again!!!");
    }
}
