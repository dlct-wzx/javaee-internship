package com.dlct.dao;

import com.dlct.pojo.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    List<Book> queryAllBook() throws SQLException;


    List<Book> queryBookByName(String name) throws SQLException;

    Book queryBookById(int id) throws SQLException;

    int updateBook(Book book) throws SQLException;

    int deleteBook(int id) throws SQLException;

    int insertBook(Book book) throws SQLException;
}
