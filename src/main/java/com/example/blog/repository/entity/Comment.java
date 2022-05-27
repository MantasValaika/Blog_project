package com.example.blog.repository.entity;

import com.example.blog.validation.CommentText;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @CommentText
    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_time")
    private LocalDateTime commentTime = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public String getFormatedDateTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(this.commentTime);
    }
}
