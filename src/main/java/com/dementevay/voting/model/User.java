package com.dementevay.voting.model;

import java.util.Set;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class User extends NamedEntity {
    private Set<Role> roles;

    private String email;

    private String password;
}
