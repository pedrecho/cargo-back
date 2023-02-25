package com.kursach.controller;


import com.kursach.entity.Book;
import com.kursach.repository.BookRepository;
import com.kursach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    private final BookRepository book;

    BookController(BookRepository book) {
        this.book = book;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public @ResponseBody Optional<Book> GetById(@PathVariable(name = "id") Long id) {
        return this.book.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return bookService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public @ResponseBody List<Book> GetAll() {
        return this.book.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(Book book) {
        return bookService.Save(book);
    }
}