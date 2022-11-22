package com.dlct.controller;

import com.dlct.dao.BookDao;
import com.dlct.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/book/deleteBook")
public class deleteBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BookDao bookService = new BookService();
        try {
            int i = bookService.deleteBook(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/book/allBook");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
