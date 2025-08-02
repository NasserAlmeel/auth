package com.example.auth.controller;

import com.example.auth.entity.UserType;
import com.example.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam UserType userType) {
        return ResponseEntity.ok(authService.register(username, password, email, userType));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String username,
            @RequestParam String password) {
        UserType userType = authService.login(username, password);
        return ResponseEntity.ok().body(
                new LoginResponse("Login successful", userType));
    }

    private record LoginResponse(String message, UserType userType) {}
}