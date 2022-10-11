package com.dlct.pojo;

import java.sql.Date;

public class Book {
    private int id;
    private String book_name;
    private String author;
    private  int price;
    private String press;
    private Date press_date;

    public Book(int id, String book_name, String author, int price, String press, Date press_date) {
        this.id = id;
        this.book_name = book_name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.press_date = press_date;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", press_date=" + press_date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPress_date() {
        return press_date;
    }

    public void setPress_date(Date press_date) {
        this.press_date = press_date;
    }
}
