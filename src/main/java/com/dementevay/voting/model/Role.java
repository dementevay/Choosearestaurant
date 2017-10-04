package com.dementevay.voting.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Andrey Dementev on 24.07.17.
 */

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}

