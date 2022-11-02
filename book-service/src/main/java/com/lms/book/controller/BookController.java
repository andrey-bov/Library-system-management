package com.lms.book.controller;

import com.lms.book.dto.BookDTO;
import com.lms.book.entity.Book;
import com.lms.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long bookId) {
        BookDTO bookDTO =  new BookDTO(bookService.getBookId(bookId));
        return ResponseEntity.ok(bookDTO);
    }

    @PostMapping("/")
    public ResponseEntity<Long> addBook(@RequestBody BookDTO bookDTO) {
        Long addBook = bookService.addBook(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getData(), OffsetDateTime.now());
        return ResponseEntity.ok(addBook);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long bookId, @RequestBody BookDTO bookRequestDTO) {
        BookDTO bookDTO = new BookDTO(bookService.updateBook(bookId, bookRequestDTO.getTitle(),
                bookRequestDTO.getAuthor(), bookRequestDTO.getData()));
        return ResponseEntity.ok(bookDTO);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long bookId) {
        BookDTO bookDTO = new BookDTO(bookService.deleteBook(bookId));
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
