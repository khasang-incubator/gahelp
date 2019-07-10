package io.khasang.gahelp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {
    @Pointcut("execution(* io.khasang.gahelp.service.impl.KnightServiceImpl.getAchievement(..))")
    public void serviceBefore() {

    }

    @Before("execution(* io.khasang.gahelp.service.impl.KnightServiceImpl.getAchievement(..))")
    public void getSong(JoinPoint joinPoint) {
        System.err.println("LAlalalala!!!");
    }

    @Around("execution(* io.khasang.gahelp.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
    public Object action(ProceedingJoinPoint joinPoint, String val) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeAfter = System.currentTimeMillis();
        System.err.println("Lalalalalala...");

        System.err.println("Knight defeat an enemy - " + val + " with " + (timeAfter - timeBefore) / 1000 + " seconds");
        return obj;
        }
    }
