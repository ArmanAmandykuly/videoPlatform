package com.example.videoPlatform.auth.services;

import com.example.videoPlatform.auth.dto.AccountDTO;
import com.example.videoPlatform.auth.repositories.AccountRepository;
import com.example.videoPlatform.auth.security.AccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountDTO> optionalAccountDTO = accountRepository.findByUsername(username);;

        if(optionalAccountDTO.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }

        AccountDTO accountDTO = optionalAccountDTO.get();

        return AccountDetails.builder()
                .username(accountDTO.getUsername())
                .password(accountDTO.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(accountDTO.getRole())))
                .build();
    }
}
