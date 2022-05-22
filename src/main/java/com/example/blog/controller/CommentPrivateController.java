package com.example.blog.controller;

import com.example.blog.repository.entity.Comment;
import com.example.blog.repository.entity.Post;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/private/posts")
@RequiredArgsConstructor
public class CommentPrivateController {

    private final CommentService commentService;
    private final PostService postService;

    @GetMapping("/{post_id}/comment")
    @PreAuthorize("hasRole('ADMIN')")
    public String getCommentForm(Model model) {
        return "commentForm";
    }

    @PostMapping("/{post_id}/createComment")
    @PreAuthorize("hasRole('ADMIN')")
    public String createComment(@Valid Comment comment, @Valid Post post, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "commentForm";
        }
        Comment createdComment = commentService.create(comment, post.getPost_id());

        model.addAttribute("comment", createdComment);
        model.addAttribute("post_id", post);
        return "redirect:/public/posts/" + post.getPost_id();
    }

    @ModelAttribute("comment")
    public Comment populateEmptyComment() {
        return new Comment();
    }
}
