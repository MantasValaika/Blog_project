package com.example.blog.service;

import com.example.blog.repository.RoleRepository;
import com.example.blog.repository.entity.Authority;
import com.example.blog.repository.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findRole(Authority role) {
        return roleRepository.findByRole(role)
                .orElseThrow(() -> new UsernameNotFoundException("User with Role: " + role + " was not found"));
    }
}
