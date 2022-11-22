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

@WebServlet(urlPatterns = "/book")
public class bookService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equals("addBook")) {
            //添加书籍
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
            resp.sendRedirect("/book?type=allBook");
        }else if (type.equals("allBook")){
            //获取所有书籍
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
        else if(type.equals("deleteBook")){
            //删除书籍
            int id = Integer.parseInt(req.getParameter("id"));
            BookDao bookService = new BookService();
            try {
                int i = bookService.deleteBook(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("/book?type=allBook");
        }
        else if(type.equals("selectBook")){
            //查询书籍
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
        }else if(type.equals("updateBook")){
            //更新书籍
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
            resp.sendRedirect("/book?type=allBook");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
