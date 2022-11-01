package com.lms.book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String title;

    private String author;

    private Integer data;

    private OffsetDateTime creationDate;

    public Book(String title, String author, Integer data) {
        this.title = title;
        this.author = author;
        this.data = data;
    }

    public Book(String title, String author, Integer data, OffsetDateTime creationDate) {
        this.title = title;
        this.author = author;
        this.data = data;
        this.creationDate = creationDate;
    }

    public Book(Long bookId, String title, String author, Integer data) {
        this.title = title;
        this.author = author;
        this.data = data;
        this.bookId = bookId;
    }

}