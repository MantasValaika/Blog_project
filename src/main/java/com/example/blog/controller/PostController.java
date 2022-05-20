package com.example.blog.controller;

import com.example.blog.repository.entity.Post;
import com.example.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

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
            @PathVariable(name = "post_id") Long post_id,
            @RequestParam(name = "author_name", required = false) boolean showPost,
            Model model
    ) {
        Post post = postService.findById(post_id);

        model.addAttribute("author_name", showPost);
        model.addAttribute("post", post);

        return "postPage";
    }

    @GetMapping("/post")
    public String getPostForm(Model model) {
        return "postForm";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid Post post, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "postForm";
        }
        Post createdPost = postService.create(post);

        model.addAttribute("post", createdPost);
        return "redirect:/posts/" + createdPost.getPost_id();
    }

    @ModelAttribute("post")
    public Post populateEmptyPost() {
        return new Post();
    }

}
