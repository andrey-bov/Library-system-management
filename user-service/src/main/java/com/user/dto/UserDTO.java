package com.user.dto;

import com.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private Long userId;

    private String email;

    private String name;

    private String phone;

    private OffsetDateTime creationData;

    public UserDTO(User user) {
        userId = user.getUserId();
        name = user.getName();
        phone = user.getPhone();
        creationData = user.getCreationData();
        email = user.getEmail();
    }
}
