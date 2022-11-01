package com.lms.book.dto;

import com.lms.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;
@AllArgsConstructor
@Getter
public class BookResponseDTO {

    private Long bookId;

    private String title;

    private String author;

    private Integer data;

    private OffsetDateTime creationDate;

    public BookResponseDTO(Book book) {
        bookId = book.getBookId();
        title = book.getTitle();
        author = book.getAuthor();
        data = book.getData();
        creationDate = book.getCreationDate();
    }
}
