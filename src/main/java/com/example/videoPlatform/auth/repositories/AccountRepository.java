package com.example.videoPlatform.auth.repositories;

import com.example.videoPlatform.auth.dto.AccountDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository {
    Optional<AccountDTO> findByUsername(String username);

    void save(AccountDTO accountDTO);
}
