package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

//实现过滤器接口
@WebFilter("/admin.jsp")
public class check implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //获取request、response、session对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String error = null;
        //获取账号密码
        String account = (String) req.getParameter("account");
        String password = (String) req.getParameter("password");

        //判断错误
        if (!"123456".equals(account) && !"123456".equals(password)) {
            error = "账号和密码";
        } else if (!"123456".equals(account)) {
            error = "账号";
        } else if (!"123456".equals(password)) {
            error = "密码";
        }

        if (error != null) {
            //有错
            session.setAttribute("error_my", error);
            System.out.println("有错");
            response.sendRedirect("login.jsp");
        } else {
            //无错放行
            Cookie cookie1 = new Cookie("account", account);
            Cookie cookie2 = new Cookie("password", password);
            response.addCookie(cookie1);
            response.addCookie(cookie2);

            session.setAttribute("rem", true);
            session.removeAttribute("error_my");
            filterChain.doFilter(req, resp);
            System.out.println("无错");
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
