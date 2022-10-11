package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String hobbies = Arrays.toString(req.getParameterValues("hobby"));
        HttpSession session = req.getSession();
        if(age < 16){
            session.setAttribute("error_my", "年纪小于16");
        } else {
            session.setAttribute("name", name);
            session.setAttribute("age", age);
            session.setAttribute("sex", sex);
            session.setAttribute("hobbies", hobbies);

        }
        resp.sendRedirect("result.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
