package com.example.videoPlatform.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private String username;

    private String password;

    private String role;
}
