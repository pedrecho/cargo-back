package com.kursach.controller;


import com.kursach.entity.Book;
import com.kursach.repository.BookRepository;
import com.kursach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private final BookRepository book;

    BookController(BookRepository book) {
        this.book = book;
    }

    @GetMapping(path = "/book/{id}")
    public @ResponseBody Optional<Book> GetById(@PathVariable(name = "id") Long id) {
        return this.book.findById(id);
    }

    @PostMapping(path = "/book/{id}")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return bookService.Delete(id);
    }

    @GetMapping(path = "/book")
    public @ResponseBody List<Book> GetAll() {
        return this.book.findAll();
    }

    @PostMapping(path = "/book")
    public HttpStatus Save(Book book) {
        return bookService.Save(book);
    }
}