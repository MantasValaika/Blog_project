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

    @GetMapping("/{postId}/comment")
    @PreAuthorize("hasRole('ADMIN')")
    public String getCommentForm(
            @PathVariable(name = "postId") Long postId,
            Model model) {
        model.addAttribute("postId", postId);
        return "commentForm";
    }

    @PostMapping("/{postId}/createComment")
    @PreAuthorize("hasRole('ADMIN')")
    public String createComment(
            @PathVariable(name = "postId") Long postId,
            @Valid Comment comment,
            BindingResult errors,
            Model model) {
        if (errors.hasErrors()) {
            return "commentForm";
        }
        Comment createdComment = commentService.create(comment, postId);

        model.addAttribute("comment", createdComment);
        model.addAttribute("postId", postId);
        return "redirect:/public/posts/" + postId;
    }

    @ModelAttribute("comment")
    public Comment populateEmptyComment() {
        return new Comment();
    }
}
