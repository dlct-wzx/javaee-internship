package com.dlct.controller;

import com.dlct.dao.BookDao;
import com.dlct.pojo.Book;
import com.dlct.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/book/allBook")
public class allBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookService = new BookService();
        List<Book> books = null;
        try {
            books = bookService.queryAllBook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("list", books);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
