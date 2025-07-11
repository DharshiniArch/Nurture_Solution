package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        String credentials = new String(Base64Utils.decodeFromString(base64Credentials));
        String[] parts = credentials.split(":", 2);

        String username = parts[0];
        String password = parts[1];

        // Basic user check
        if ("user".equals(username) && "pwd".equals(password)) {
            String token = JwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
