package com.example.videoPlatform.auth.services;

import com.example.videoPlatform.auth.dto.AccountDTO;
import com.example.videoPlatform.auth.repositories.AccountRepository;
import com.example.videoPlatform.auth.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JWTUtil jwtUtil;

    private final AuthenticationManager authManager;

    private final AccountRepository accountRepository;

    public LoginResponse attemptLogin(LoginRequest dto) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();

        List<String> roles = accountDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String token = jwtUtil.issue(dto.getUsername(), roles);

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

    public void register(AccountDTO dto) throws RuntimeException{
        if(accountRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("Account with such an username already exists");
        }

        accountRepository.save(dto);
    }

    public ResponseEntity<String> update(UpdateRequest dto) throws RuntimeException{
        Optional<AccountDTO> accountDTOOptional = accountRepository.findByUsername(dto.getUsername());

        if(accountDTOOptional.isEmpty()) {
            throw new RuntimeException("Account with such an username doesn't exist");
        }

        return ResponseEntity.ok("Account's password is... kinda updated, not sure, lol");
    }


}
