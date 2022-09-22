package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //组合service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("list", booksList);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Books books) {
        if (bookService.addBook(books) > 0) {
            return "redirect:/book/allBook";
        } else {
            return "addBook";
        }

    }

    @RequestMapping("/toUpdateBook")
    public String toUpdate(@RequestParam("id") int bookID,
                           Model model) {

        Books books = bookService.queryBookById(bookID);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(
            Books books,
            Model model) {
        if (bookService.updateBook(books) > 0) {
            // Books book = bookService.queryBookById(books.getBookID());
            // model.addAttribute("books", book);
            return "redirect:/book/allBook";
        } else {
            model.addAttribute("books", books);
            return "updateBook";
        }
    }

    @RequestMapping("/del/{bookID}")
    public String del(@PathVariable("bookID") int bookID) {
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }
}
