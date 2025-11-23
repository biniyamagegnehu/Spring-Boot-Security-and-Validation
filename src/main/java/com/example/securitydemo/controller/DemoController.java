package com.example.securitydemo.controller;

import com.example.securitydemo.dto.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class DemoController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public OK";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "User OK — authenticated user";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Admin OK — admin only";
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest req) {
        // Demo: we do not persist users — just echo back
        return ResponseEntity.ok(Map.of(
                "message", "User payload valid",
                "username", req.getUsername()
        ));
    }
}
