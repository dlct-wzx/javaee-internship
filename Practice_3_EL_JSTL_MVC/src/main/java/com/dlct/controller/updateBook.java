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

@WebServlet("/book/updateBook")
public class updateBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookService = new BookService();
        int Id = Integer.parseInt(req.getParameter("bookID"));
        String bookName = req.getParameter("bookName");
        int bookCounts = Integer.parseInt(req.getParameter("bookCounts"));
        String detail = req.getParameter("detail");

        Book book = new Book(Id, bookName, bookCounts, detail);
        try {
            bookService.updateBook(book);
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
