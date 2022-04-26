package com.example.blog.Repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "post_time")
    private Date postTime;
}
