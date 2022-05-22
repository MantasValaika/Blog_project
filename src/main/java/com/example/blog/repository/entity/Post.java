package com.example.blog.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "post")
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

    @Column(name = "post_time")
    private LocalDateTime postTime = LocalDateTime.now();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public String getFormatedDateTime() {
        return postTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}