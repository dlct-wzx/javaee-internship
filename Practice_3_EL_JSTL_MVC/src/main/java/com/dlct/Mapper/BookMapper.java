package com.dlct.Mapper;

import com.dlct.pojo.Book;

import java.util.List;

public interface BookMapper {

    List<Book> queryAllBook();

    Book queryBookById(int id);

    Book queryBookByName(String name);

    int updateBook(Book book);

    int deleteBook(int id);

    int insertBook(Book book);
}
