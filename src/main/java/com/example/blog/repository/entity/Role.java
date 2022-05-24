package com.example.blog.repository.entity;

import lombok.Data;

import javax.persistence.*;


@Table(name = "roles")
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Authority role;

}
