package com.example.blog.controller;

import com.example.blog.repository.entity.Post;
import com.example.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/private/posts")
@RequiredArgsConstructor
public class PostPrivateController {

    private final PostService postService;

    @GetMapping("/post")
    @PreAuthorize("hasRole('USER')")
    public String getPostForm(Model model) {
        return "postForm";
    }

    @PostMapping("/createPost")
    @PreAuthorize("hasRole('USER')")
    public String createPost(@Valid Post post, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "postForm";
        }
        Post createdPost = postService.create(post);

        model.addAttribute("post", createdPost);
        return "redirect:/public/posts/" + createdPost.getPost_id();
    }

    @ModelAttribute("post")
    public Post populateEmptyPost() {
        return new Post();
    }
}
