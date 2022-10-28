package com.dlct.service;

import com.dlct.Mapper.BookMapper;
import com.dlct.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    private BookMapper mapper;


    public int addBook(Books book) {
        return mapper.addBook(book);
    }

    public int deleteBook(int id) {
        return mapper.deleteBook(id);
    }

    public int updateBook(Books book) {
        return mapper.updateBook(book);
    }

    public Books selectBookById(int id) {
        return mapper.selectBookById(id);
    }

    public List<Books> selectAllBook() {
        return mapper.selectAllBook();
    }

    @Override
    public List<Books> selectBookByName(String bookName) {
        return mapper.selectBookByName(bookName);
    }

    public BookMapper getMapper() {
        return mapper;
    }

    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }
}
