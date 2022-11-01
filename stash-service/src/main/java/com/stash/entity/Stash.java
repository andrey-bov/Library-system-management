package com.stash.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Stash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stashId;

    private Long bookId;

    private Long userId;

    private OffsetDateTime creationDate;
}
