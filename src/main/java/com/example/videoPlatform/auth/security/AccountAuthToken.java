package com.example.videoPlatform.auth.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AccountAuthToken extends AbstractAuthenticationToken {

    private final AccountDetails accountDetails;
    public AccountAuthToken(AccountDetails accountDetails) {
        super(accountDetails.getAuthorities());
        this.accountDetails = accountDetails;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return accountDetails.getAuthorities();
    }

    @Override
    public AccountDetails getPrincipal() {
        return accountDetails;
    }
}
