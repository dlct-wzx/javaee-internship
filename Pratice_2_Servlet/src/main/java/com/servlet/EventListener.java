package com.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;


public class EventListener implements ServletContextListener, ServletRequestListener, HttpSessionListener
{
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
// 当有一个会话创建，则给当前在线人数加 1
        int cnt = 0;
        ServletContext context = arg0.getSession().getServletContext();
        Object sessionCnt = context.getAttribute("sessionCnt");
        if(sessionCnt != null){
            cnt = (Integer)sessionCnt;
        }
        cnt++;
        context.setAttribute("sessionCnt", cnt);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
// 当有一个会话关闭时，则给当前在线人数减 1
        int cnt = 0;
        ServletContext context = arg0.getSession().getServletContext();
        Object sessionCnt = context.getAttribute("sessionCnt");
        if(sessionCnt != null){
            cnt = (Integer)sessionCnt;
            cnt--;
        }
        context.setAttribute("sessionCnt", cnt);
    }
    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {}
    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
// 每有一个请求，则计数
        int cnt = 0;
        Object reqcnt = arg0.getServletContext().getAttribute("reqcnt");
        if(reqcnt != null){
            cnt = (Integer)reqcnt;
        }
        cnt++;
        arg0.getServletContext().setAttribute("reqcnt", cnt);
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {}
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
// 保存应用启动时间
        arg0.getServletContext().setAttribute("StartDate", new Date());
    }
}
