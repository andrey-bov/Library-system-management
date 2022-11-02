package com.lms.book.dto;

import com.lms.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Long bookId;

    private String title;

    private String author;

    private Integer data;

    private OffsetDateTime addDataTime;

    public BookDTO(Book book) {
        bookId = book.getBookId();
        title = book.getTitle();
        author = book.getAuthor();
        data = book.getData();
        addDataTime = book.getAddDataTime();
    }
}
