package com.kursach.service;


import com.kursach.entity.Book;
import com.kursach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public HttpStatus Save(Book book) {
        bookRepository.save(book);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long bookId) {
        if (bookRepository.findById(bookId).isPresent()) {
            bookRepository.deleteById(bookId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

}
