package com.lms.order.dto;

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

}
