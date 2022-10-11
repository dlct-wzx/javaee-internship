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

@Alias("book")
public interface BookMapper {
    //@Select("select * from javaee_practice.books")
    List<Book> selectAllBook();

    //@Select("select * from javaee_practice.books where id=#{id}")
    Book selectBookById(int id);

    Book selectBookByMap(Map map);


    //@Delete("delete from javaee_practice.books where id = #{id}")
    int deleteBookById(int id);

    //@Insert("insert into\n" +
    //        "        javaee_practice.books(book_name, author, price, press, press_date)\n" +
    //        "        VALUES (#{book_name}, #{author}, #{price}, #{press}, #{press_date})")
    int insertBook(Book book);

    //@Update("update javaee_practice.books\n" +
    //        "        set book_name = #{book_name},\n" +
    //        "            author = #{author},\n" +
    //        "            price = #{price},\n" +
    //        "            press = #{press},\n" +
    //        "            press_date = #{press_date}\n" +
    //        "        where id = #{id}")
    int updateBook(Book book);
}
