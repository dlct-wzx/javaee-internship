package com.dlct.aop;

import com.dlct.model.UserLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;

@Aspect
@Component
public class cutPoint {
    @Pointcut(value = "execution(* com.dlct.model.*Service.*(..))")
    public void cutPoint(){}

    @After(value = "cutPoint()")
    public void log(JoinPoint point) throws SQLException, ClassNotFoundException {
        System.out.println(point.getSignature() + "方法被执行.....");
        String log = point.getSignature() + "方法被执行.....";
        Date date = new Date();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserLog bean = context.getBean(UserLog.class);
        bean.insertLog(log, date);
    }

}
