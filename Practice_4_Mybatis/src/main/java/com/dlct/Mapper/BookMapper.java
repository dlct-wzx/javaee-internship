package com.dlct.Mapper;

import com.dlct.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.Alias;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Alias("book")  //别名
public interface BookMapper {
    //@Select("select * from javaee_practice.books")
    List<Book> selectAllBook();     //查询全部书籍

    //@Select("select * from javaee_practice.books where id=#{id}")
    Book selectBookById(int id);    //通过id查询书籍

    //@Delete("delete from javaee_practice.books where id = #{id}")
    int deleteBookById(int id);     //通过id删除书籍

    //@Insert("insert into" +
    //        "        javaee_practice.books(book_name, author, price, press, press_date)" +
    //        "        VALUES (#{book_name}, #{author}, #{price}, #{press}, #{press_date})")
    int insertBook(Book book);      //插入书籍

    //@Update("update javaee_practice.books" +
    //        "        set book_name = #{book_name}," +
    //        "            author = #{author}," +
    //        "            price = #{price}," +
    //        "            press = #{press}," +
    //        "            press_date = #{press_date}" +
    //        "        where id = #{id}")
    int updateBook(Book book);      //更新书籍

    List<Book> selectBookByMap(Map map);    //模糊查询
}
