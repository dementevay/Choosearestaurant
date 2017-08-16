package com.dementevay.voting.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@NamedQueries({
        @NamedQuery(name = User.GET_ALL, query = "SELECT u FROM User u"),
        @NamedQuery(name = User.GET_USER_ROLE, query = "SELECT u FROM User u WHERE u.id = :id")
})

@Entity
@Table(name = "users")
public class User extends NamedEntity {
    public static final String GET_ALL = "User.getAll";
    public static final String GET_USER_ROLE = "User.ROLES";

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    protected Set<Role> roles;

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

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(),  u.isEnabled(), u.getRoles());
    }

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, password,  true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, boolean enabled, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
