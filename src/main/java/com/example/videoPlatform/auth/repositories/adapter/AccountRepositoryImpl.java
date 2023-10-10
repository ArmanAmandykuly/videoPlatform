package com.example.videoPlatform.auth.repositories.adapter;

import com.example.videoPlatform.auth.dto.AccountDTO;
import com.example.videoPlatform.auth.repositories.AccountRepository;
import com.example.videoPlatform.auth.repositories.impl.AccountManualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountManualRepository repository;
    @Override
    public Optional<AccountDTO> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void save(AccountDTO accountDTO) {
        repository.save(accountDTO);
    }
}
