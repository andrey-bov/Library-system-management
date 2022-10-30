package com.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor

public class UserRequestDTO {

    private String email;

    private String name;

    private String phone;

    private OffsetDateTime creationData;
}
