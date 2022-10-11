package com.dlct.test;

import com.dlct.Mapper.BookMapper;
import com.dlct.Utils.MybatisUtils;
import com.dlct.pojo.Book;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.sql.Date;

import java.util.HashMap;
import java.util.List;

public class Mytest {
    @Test
    public void selectAllBook(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = mapper.selectAllBook();
        for (Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void selectBookById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = mapper.selectBookById(1);
        System.out.println(book);
        sqlSession.close();
    }

    @Test
    public void selectBookByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("book_name", "javaee");
        Book book = mapper.selectBookByMap(hashMap);
        System.out.println(book);
        sqlSession.close();

    }

    @Test
    public void deleteBookById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        mapper.deleteBookById(1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertBook(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book(1, "javaee", "邹青", 45, "西北农林科技大学出版社", new Date(2022, 10, 10));
        int ju = mapper.insertBook(book);
        System.out.print(ju);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateBook(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book(3, "javaee", "邹青", 45, "西北农林科技大学出版社", new Date(122, 9, 10));
        mapper.updateBook(book);
        sqlSession.commit();
        sqlSession.close();
    }
}
