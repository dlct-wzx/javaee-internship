package com.dlct.Filter;

import com.dlct.dao.UserDao;
import com.dlct.pojo.User;
import com.dlct.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class loginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        UserDao userService = new UserService();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        if (session.getAttribute("rem") != null){
            //第二次登录直接放行
            filterChain.doFilter(req, resp);

            return;
        }

        String error = null;
        String account = (String) req.getParameter("account");
        String password = (String) req.getParameter("password");

        User user = null;
        try {
            user = userService.queryUserByName(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            error = "账号";
        } else if (!user.getPwd().equals(password)) {
            error = "密码";
        }

        if (error != null) {
            //有错
            session.setAttribute("error_my", error);
            System.out.println("有错");
            response.sendRedirect("index.jsp");
        } else {
            //放行
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
