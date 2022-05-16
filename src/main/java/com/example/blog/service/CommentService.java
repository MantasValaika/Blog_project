package com.example.blog.service;

import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}
