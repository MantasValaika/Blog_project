package com.example.blog.service;

import com.example.blog.exeption.PostNotFoundException;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.entity.Comment;
import com.example.blog.repository.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public Comment create(Comment comment, Long postId) {
        Post post = postService.findById(postId);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }
}
