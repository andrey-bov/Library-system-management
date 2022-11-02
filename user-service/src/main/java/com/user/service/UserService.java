package com.user.service;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long UserId) {
        return userRepository.findById(UserId).
                orElseThrow(() -> new UserNotFoundException("Unable to find user with id: " + UserId));
    }

    public Long createUser(String name, String email, String phone) {
        User user = new User(name,email,phone, OffsetDateTime.now());
        return userRepository.save(user).getUserId();
    }

    public User updateUser(Long userId, String name, String email, String phone) {
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setCreationData(OffsetDateTime.now());
        return this.userRepository.save(user);
    }

    public User deleteUser(Long userId) {
        User deleteUser = getUserById(userId);
         userRepository.deleteById(userId);
         return deleteUser;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
