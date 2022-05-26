package com.example.blog.service;

import com.example.blog.repository.PostRepository;
import com.example.blog.repository.entity.Post;
import com.example.blog.exeption.PostNotFoundException;
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

    public Post create(Post post) {
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
