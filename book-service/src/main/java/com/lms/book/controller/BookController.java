package com.lms.book.controller;

import com.lms.book.dto.BookRequestDTO;
import com.lms.book.dto.BookResponseDTO;
import com.lms.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public BookResponseDTO getBook(@PathVariable Long bookId) {
        return new BookResponseDTO(bookService.getBookId(bookId));
    }

    @PostMapping("/")
    public Long createBook(@RequestBody BookRequestDTO bookRequestDTO) {
        return bookService.createBook(bookRequestDTO.getTitle(), bookRequestDTO.getAuthor(), bookRequestDTO.getData(), OffsetDateTime.now());
    }

    @PutMapping("/{bookId}")
    public BookResponseDTO updateBook(@PathVariable Long bookId, @RequestBody BookRequestDTO bookRequestDTO) {
        return new BookResponseDTO(bookService.updateBook(bookId, bookRequestDTO.getTitle(), bookRequestDTO.getAuthor(), bookRequestDTO.getData()));
    }

    @DeleteMapping("/{bookId}")
    public BookResponseDTO deleteBook(@PathVariable Long bookId) {
        return new BookResponseDTO(bookService.deleteBook(bookId));
    }
}
