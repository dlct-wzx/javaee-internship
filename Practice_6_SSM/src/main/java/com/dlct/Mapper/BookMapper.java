package com.dlct.Mapper;

import com.dlct.pojo.Books;

import java.util.List;


public interface BookMapper {
    //增
    int addBook(Books book);

    //删
    int deleteBook(int id);

    //改
    int updateBook(Books book);

    //查一本书
    Books selectBookById(int id);

    //查全部书
    List<Books> selectAllBook();

    List<Books> selectBookByName(String bookName);
}
