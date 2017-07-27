package com.dementevay.voting.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@NamedQueries({
        @NamedQuery(name = User.GET_ALL,
                query = "SELECT m FROM User m")
})

@Entity
@Table(name = "users")
public class User extends NamedEntity {
    public static final String GET_ALL = "User.getAll";

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @Email
    @NotBlank
    @SafeHtml
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @Length(min = 5)
    @SafeHtml
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    public User(){}

    public User(Set<Role> roles, String email, String password, boolean enabled) {
        this.roles = roles;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }
}
