package com.example.blog.repository;

import com.example.blog.repository.entity.Authority;
import com.example.blog.repository.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(Authority role);
}
