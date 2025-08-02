package com.example.auth.controller;

import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/admin")
    @Secured("ADMIN")
    public ResponseEntity<String> adminEndpoint() {
        return ResponseEntity.ok("This is an ADMIN endpoint");
    }

    @GetMapping("/user")
    @Secured("USER")
    public ResponseEntity<String> userEndpoint() {
        return ResponseEntity.ok("This is a USER endpoint");
    }

    @GetMapping("/users")
    @Secured("ADMIN")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
