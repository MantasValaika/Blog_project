package com.example.blog.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(name = "title")
    private String title;

    @Column(name = "posted_text")
    private String postedText;

    @Column(name = "author_name")
    private String authorName;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "post_time")
    private LocalDateTime postTime = LocalDateTime.now();
}
