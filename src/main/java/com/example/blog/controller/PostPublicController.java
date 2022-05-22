package com.example.blog.controller;

import com.example.blog.repository.entity.Post;
import com.example.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/public/posts")
@RequiredArgsConstructor
public class PostPublicController {

    private final PostService postService;

    @GetMapping
    public String getPostList(
            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
            Model model
    ) {

        Page<Post> postPage = postService.findAllPageable(5, pageNumber);

        List<Post> products = postPage.getContent();

        model.addAttribute("posts", products);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", postPage.getTotalPages());

        return "postList";
    }

    @GetMapping(path = "/{post_id}")
    public String getPostPage(
            @PathVariable(name = "post_id") Long postId,
            @RequestParam(name = "author_name", required = false) boolean showPost,
            Model model
    ) {
        Post post = postService.findById(postId);

        model.addAttribute("author_name", showPost);
        model.addAttribute("post", post);

        return "postPage";
    }
}
