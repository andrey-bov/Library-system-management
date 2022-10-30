package com.user.controller;

import com.user.dto.UserRequestDTO;
import com.user.dto.UserResponseDTO;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUser(@PathVariable Long userId) {
        return new UserResponseDTO(userService.getUserById(userId));
    }

    @PostMapping("/")
    public Long createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO.getName(),
                userRequestDTO.getEmail(), userRequestDTO.getPhone());
    }

    @PutMapping("/{userId}")
    public UserResponseDTO updateUser(@RequestBody UserRequestDTO userRequestDTO,
                                      @PathVariable Long userId) {
        return new UserResponseDTO(userService.updateUser(userId, userRequestDTO.getName(),
                userRequestDTO.getEmail(), userRequestDTO.getPhone()));
    }

    @DeleteMapping("/{userId}")
    public UserResponseDTO deleteUser(@PathVariable Long userId) {
        return new UserResponseDTO(userService.deleteUser(userId));
    }
}
