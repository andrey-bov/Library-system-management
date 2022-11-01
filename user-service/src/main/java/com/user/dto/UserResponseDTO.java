package com.user.dto;

import com.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter

public class UserResponseDTO {

    private Long UserId;

    private String email;

    private String name;

    private String phone;

    private OffsetDateTime creationData;

    public UserResponseDTO(User user) {
        UserId = user.getUserId();
        name = user.getName();
        phone = user.getPhone();
        creationData = user.getCreationData();
        email = user.getEmail();
    }
}
