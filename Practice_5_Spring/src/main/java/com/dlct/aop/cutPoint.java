package com.dlct.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Aspect
@Component
public class cutPoint {
    @Pointcut(value = "execution(* com.dlct.model.*Service.*(..))")
    public void cutPoint(){}

    @After(value = "cutPoint()")
    public void log(JoinPoint point){
        System.out.println(point.getSignature() + "方法被执行.....");

    }

}
