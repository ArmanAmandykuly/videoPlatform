package com.example.videoPlatform.auth.controllers;

import com.example.videoPlatform.auth.dto.AccountDTO;
import com.example.videoPlatform.auth.security.LoginRequest;
import com.example.videoPlatform.auth.security.LoginResponse;
import com.example.videoPlatform.auth.security.UpdateRequest;
import com.example.videoPlatform.auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody AccountDTO dto) throws RuntimeException {
        try {
            authService.register(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) throws RuntimeException{
        return authService.attemptLogin(request);
    }

    @PostMapping("update")
    public ResponseEntity<String> update(@RequestBody UpdateRequest request) throws RuntimeException {
        return authService.update(request);
    }
}
