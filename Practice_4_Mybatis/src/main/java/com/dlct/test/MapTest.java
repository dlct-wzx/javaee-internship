package com.dlct.test;

import com.dlct.Mapper.BookMapper;
import com.dlct.Utils.MybatisUtils;
import com.dlct.pojo.Book;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MapTest {
    @Test
    public void selectBookByBookName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("book_name", "java");       //查询书名字中含java的书
        List<Book> book = mapper.selectBookByMap(hashMap);
        for (Book book1 : book) {
            System.out.println(book1);
        }
        sqlSession.close();
    }

    @Test
    public void selectBookByAuthor(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("author", "邹");     //查询作者名字中含邹的书
        List<Book> book = mapper.selectBookByMap(hashMap);
        for (Book book1 : book) {
            System.out.println(book1);
        }
        sqlSession.close();
    }

    @Test
    public void selectBookByPress(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("press", "西北");     //查询出版社名字中含西北的书
        List<Book> book = mapper.selectBookByMap(hashMap);
        for (Book book1 : book) {
            System.out.println(book1);
        }
        sqlSession.close();
    }

    @Test
    public void selectBookByPrice(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("price", "38");     //查询价格大于40的书
        List<Book> book = mapper.selectBookByMap(hashMap);
        for (Book book1 : book) {
            System.out.println(book1);
        }
        sqlSession.close();
    }

    @Test
    public void selectBookByPriceDate(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("press_date", "2022-10-28");     //查询在2022/10/28号之后出版的书
        List<Book> book = mapper.selectBookByMap(hashMap);
        for (Book book1 : book) {
            System.out.println(book1);
        }
        sqlSession.close();
    }

    @Test
    public void selectBookByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("press_date", "2022-10-28");    //查询在2022/10/28号之后出版的书
        hashMap.put("price", "28");                 //查询价格大于28的书
        hashMap.put("press", "西北");                //查询出版社名字中含西北的书
        hashMap.put("author", "邹");                //查询作者名字中含邹的书
        hashMap.put("book_name", "lin");           //查询书名字中含java的书
        List<Book> book = mapper.selectBookByMap(hashMap);
        for (Book book1 : book) {
            System.out.println(book1);
        }
        sqlSession.close();
    }
}
