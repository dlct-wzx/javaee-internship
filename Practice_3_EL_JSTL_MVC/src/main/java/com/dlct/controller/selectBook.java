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

@WebServlet("/book/selectBookByName")
public class selectBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        BookDao bookService = new BookService();
        List<Book> book = null;
        try {
            book = bookService.queryBookByName(bookName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (book.isEmpty()){
            try {
                book = bookService.queryAllBook();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("errorr", "未找到");
            System.out.println("未找到");
        }
        System.out.println(book);
        //req.removeAttribute("list");
        req.setAttribute("list", book);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
