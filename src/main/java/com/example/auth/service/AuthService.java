package com.example.auth.service;

import com.example.auth.entity.User;
import com.example.auth.entity.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    public User register(String username, String password, String email, UserType userType) {
        return userService.registerUser(username, password, email, userType);
    }

    public UserType login(String username, String password) {
        User user = userService.authenticateUser(username, password);
        return user.getUserType();
    }
}