package com.dlct.service;

import com.dlct.dao.BookDao;
import com.dlct.pojo.Book;
import com.dlct.pojo.User;
import com.dlct.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookService implements BookDao {
    @Override
    public List<Book> queryAllBook() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "select * from ssm.books";
        ResultSet res = stat.executeQuery(sql);

        ArrayList<Book> books = new ArrayList<>();
        while(res.next()){
            Book book = new Book();
            book.setBookID(res.getInt("bookID"));
            book.setBookName(res.getString("bookName"));
            book.setBookCounts(res.getInt("bookCounts"));
            book.setDetail(res.getString("detail"));
            books.add(book);
        }
        JdbcUtils.close(connection, stat, res);
        return books;
    }

    @Override
    public List<Book> queryBookByName(String name) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "select * from ssm.books where bookName ='" + name + "'";
        ResultSet res = stat.executeQuery(sql);


        ArrayList<Book> books = new ArrayList<>();
        while(res.next()){
            Book book = new Book();
            book.setBookID(res.getInt("bookID"));
            book.setBookName(res.getString("bookName"));
            book.setBookCounts(res.getInt("bookCounts"));
            book.setDetail(res.getString("detail"));
            books.add(book);
        }

        JdbcUtils.close(connection, stat, res);
        return books;
    }

    @Override
    public Book queryBookById(int id) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "select * from ssm.books where bookID=" + id;
        ResultSet res = stat.executeQuery(sql);

        Book book = new Book();
        while(res.next()){

            book.setBookID(res.getInt("bookID"));
            book.setBookName(res.getString("bookName"));
            book.setBookCounts(res.getInt("bookCounts"));
            book.setDetail(res.getString("detail"));
        }

        JdbcUtils.close(connection, stat, res);
        return book;
    }

    @Override
    public int updateBook(Book book) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "update ssm.books " +
                "set bookName='" + book.getBookName()+
                "', bookCounts=" + book.getBookCounts() +
                ", detail='" + book.getDetail() +
                "' where bookID=" + book.getBookID();
        int i = stat.executeUpdate(sql);
        JdbcUtils.close(connection, stat, null);
        return i;
    }

    @Override
    public int deleteBook(int id) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "delete from ssm.books where bookID=" + id;
        int i = stat.executeUpdate(sql);
        JdbcUtils.close(connection, stat, null);
        return i;
    }

    @Override
    public int insertBook(Book book) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "insert into ssm.books(bookName, bookCounts, detail) " +
                "VALUE ('" + book.getBookName() + "', " + book.getBookCounts() +
                ", '" + book.getDetail() +"')";
        int i = stat.executeUpdate(sql);
        JdbcUtils.close(connection, stat, null);
        return i;
    }
}
