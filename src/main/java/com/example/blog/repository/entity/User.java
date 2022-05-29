package com.example.blog.repository.entity;

import com.example.blog.validation.EmailAdress;
import com.example.blog.validation.PhoneNumber;
import com.example.blog.validation.PhoneNumberType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Data
@Entity
@Setter
@Getter
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{post.notEmpty}")
    private String name;

    @NotEmpty(message = "{post.notEmpty}")
    private String lastName;

    @EmailAdress
    private String email;

    @PhoneNumber(phoneNumberType = PhoneNumberType.PARTIAL)
    private String phoneNumber;

    @NotEmpty(message = "{post.notEmpty}")
    private String homeAddress;

    @NotEmpty(message = "{post.notEmpty}")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "{post.notEmpty}")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
