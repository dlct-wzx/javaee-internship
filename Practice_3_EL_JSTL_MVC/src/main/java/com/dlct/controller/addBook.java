package com.dlct.controller;

import com.dlct.dao.BookDao;
import com.dlct.dao.UserDao;
import com.dlct.pojo.Book;
import com.dlct.service.BookService;
import com.dlct.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/book/addBook")
public class addBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookService = new BookService();
        String bookName = req.getParameter("bookName");
        int bookCounts = Integer.parseInt(req.getParameter("bookCounts"));
        String detail = req.getParameter("detail");

        Book book = new Book(1, bookName, bookCounts, detail);
        try {
            bookService.insertBook(book);
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
