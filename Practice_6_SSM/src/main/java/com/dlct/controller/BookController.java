package com.dlct.controller;

import com.dlct.pojo.Books;
import com.dlct.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;


    //查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.selectAllBook();
        model.addAttribute("list", books);

        return "allBook";
    }

    //跳转到增加书籍
    @RequestMapping("/toAddBook")
    private String toAddBookPage(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBookByPage(Books book){
        System.out.println("addBook=>"+book);
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBookPage(int id, Model model){
        Books books = bookService.selectBookById(id);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        System.out.println("deleteBook=>"+id);
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/selectBookByName")
    public String selectBookByName(String bookName, Model model){
        List<Books> books = bookService.selectBookByName(bookName);;
        if (books.isEmpty()){
            model.addAttribute("errorr", "未找到");
            books = bookService.selectAllBook();
        }

        model.addAttribute("list", books);
        return "allBook";
    }
}
