package com.example.videoPlatform.auth.security;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponse {
    private final String accessToken;
}
