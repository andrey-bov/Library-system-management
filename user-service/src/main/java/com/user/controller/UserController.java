package com.user.controller;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return new UserDTO(userService.getUserById(userId));
    }

    @PostMapping("/")
    public ResponseEntity<Long> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO.getName(),
                userDTO.getEmail(), userDTO.getPhone()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,
                              @PathVariable Long userId) {
        UserDTO user = new UserDTO(userService.updateUser(userId, userDTO.getName(),
                userDTO.getEmail(), userDTO.getPhone()));
        return  ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
}
