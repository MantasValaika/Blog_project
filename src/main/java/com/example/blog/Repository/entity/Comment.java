////        id INTEGER AUTO_INCREMENT PRIMARY KEY,
////        person_id INTEGER,
////        user_name VARCHAR(255) NOT NULL,
////        comment_text VARCHAR(255) NOT NULL,
////        comment_time DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
////        FOREIGN KEY (person_id) REFERENCES post(person_id)
//
//package com.example.blog.Repository.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//public class Comment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column (name = "post_id")
//    private Long post_id;
//
//    @Column(name = "user_name")
//    private String userName;
//
//    @Column(name = "comment_text")
//    private String commentText;
//
//    @Column(name = "comment_time")
//    private DateTimeFormat commentTime;
//}
