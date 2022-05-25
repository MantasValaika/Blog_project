package com.example.blog.service;

import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.repository.entity.Comment;
import com.example.blog.repository.entity.Post;
import com.example.blog.exeption.PostNotFoundException;
import com.example.blog.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    Post post = new Post();
    Comment comment = new Comment();

    public Post create(Post post, long userId) {
        User author = userRepository.getById(userId);
        post.setUser(author);
        return postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    public Page<Post> findAllPageable(int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("postTime").descending());

        return postRepository.findAll(pageable);
    }

}
