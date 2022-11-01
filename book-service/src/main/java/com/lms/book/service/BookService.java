package com.lms.book.service;

import com.lms.book.entity.Book;
import com.lms.book.exception.BookNotFoundException;
import com.lms.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookId(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow
                (() -> new BookNotFoundException("Unable to found  book with id: " + bookId));
    }

    public Long addBook(String title, String author,
                        Integer data, OffsetDateTime addDataTime) {
        Book book = new Book(title, author, data, OffsetDateTime.now());
        return bookRepository.save(book).getBookId();
    }

    public Book updateBook(Long bookId, String title, String author,
                           Integer data) {
        Book book = new Book(bookId, title, author, data);
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    public Book deleteBook(Long bookId) {
        Book deleteBook = getBookId(bookId);
        bookRepository.deleteById(bookId);
        return deleteBook;
    }
}
