package com.example.videoPlatform.auth.security;

import lombok.Data;

@Data
public class UpdateRequest {
    private String username;

    private String password;

    private String newPassword;
}
