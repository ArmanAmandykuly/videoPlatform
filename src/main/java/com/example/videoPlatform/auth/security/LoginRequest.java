package com.example.videoPlatform.auth.security;

import lombok.Data;
import lombok.Getter;

@Data
public class LoginRequest {
    private String username;

    private String password;
}
