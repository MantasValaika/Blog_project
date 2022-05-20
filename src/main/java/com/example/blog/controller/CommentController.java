package com.example.blog.controller;

import com.example.blog.repository.entity.Comment;
import com.example.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    public String getCommentForm(Model model) { return "commentForm"; }

    @PostMapping("/createComment")
    public String createComment(@Valid Comment comment, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "commentForm";
        }
        Comment createdComment = commentService.create(comment);

        model.addAttribute("comment", createdComment);
            return "redirect:/posts/";
    }

    @ModelAttribute("comment")
    public Comment populateEmptyComment() {
        return new Comment();
    }
}
