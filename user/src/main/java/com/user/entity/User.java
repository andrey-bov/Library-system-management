package com.user.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    private OffsetDateTime creationData;

    @ElementCollection
    private Set<Object> books;

    public User(String name, String email, String phone, OffsetDateTime creationData) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creationData = creationData;
    }

    public User(String name, String email, String phone, OffsetDateTime creationData, Set<Object> books) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creationData = creationData;
        this.books = books;
    }
}
