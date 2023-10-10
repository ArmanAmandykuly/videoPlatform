package com.example.videoPlatform.auth.repositories.impl;

import com.example.videoPlatform.auth.dto.AccountDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class AccountManualRepository {
    private final HashSet<String> accountUsernames;

    private final PasswordEncoder passwordEncoder;

    public AccountManualRepository() {
        accountUsernames = new HashSet<String>(List.of("user1", "user2", "user3"));
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Optional<AccountDTO> findByUsername(String username) {
        if(username.equals("user1")) {
            return Optional.of(new AccountDTO("user1", "$2a$12$3dkiKHJ8yMR/MDSAUouvz.Avnufqouw1gev/3T/BE.DOa5CST0Yf6", "ROLE_ADMIN"));
        } else if(accountUsernames.contains(username)) {
            return Optional.of(new AccountDTO(username, passwordEncoder.encode(username), "ROLE_USER"));
        }
        return Optional.empty();
    }

    public void save(AccountDTO accountDTO) {
        accountUsernames.add(accountDTO.getUsername());
    }
}
