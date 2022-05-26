package com.example.blog.controller;

import com.example.blog.repository.entity.Post;
import com.example.blog.repository.entity.User;
import com.example.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String createPost(
            @Valid Post post,
            BindingResult errors,
            Model model) {
        if (errors.hasErrors()) {
            return "postForm";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        Post createdPost = postService.create(post);

        model.addAttribute("post", createdPost);
        return "redirect:/public/posts/" + createdPost.getPostId();
    }

    @ModelAttribute("post")
    public Post populateEmptyPost() {
        return new Post();
    }

    @GetMapping("/{postId}/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String getPostEditForm(@PathVariable(name = "postId") long postId, Model model) {
        Post post = postService.findById(postId);

        model.addAttribute("post", post);
        return "postEditeForm";
    }

    @PostMapping("/edit/{postId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editPost(
            @PathVariable(name = "postId") long postId,
            @Valid Post post,
            BindingResult errors,
            Model model) {
        if (errors.hasErrors()) {
            return "postEditForm";
        }
        Post editePost = postService.edit(post);

        model.addAttribute("edit", editePost);
        return "redirect:/public/posts/" + editePost.getPostId();
    }


}
