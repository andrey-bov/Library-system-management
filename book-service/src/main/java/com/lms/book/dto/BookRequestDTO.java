package com.lms.book.dto;

import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class BookRequestDTO {

    private Long bookId;

    private String title;

    private String author;

    private Integer data;

    private OffsetDateTime creationDate;
}
