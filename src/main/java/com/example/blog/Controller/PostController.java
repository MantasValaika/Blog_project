package com.example.blog.Controller;

import com.example.blog.Repository.PostRepository;
import com.example.blog.Repository.entity.Post;
import com.example.blog.exeption.PostNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String getPostList(
            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
            Model model
    ) {
        Pageable pageable = Pageable
                .ofSize(20)
                .withPage(pageNumber);

        Page<Post> postPage = postRepository.findAll(pageable);

        List<Post> products = postPage.getContent();

        model.addAttribute("posts", products);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", postPage.getTotalPages());

        return "postList";
    }

    @GetMapping(path = "/{post_id}")
    public String getPostPage(
            @PathVariable(name = "post_id") Long post_id,
            @RequestParam(name = "showPost", required = false) boolean showPost,
            Model model
    ) {
        Optional<Post> foundPost = postRepository.findById(post_id);

        if (foundPost.isEmpty()) {
            throw new PostNotFoundException();
        }

        Post post = foundPost.get();

        model.addAttribute("author_name", showPost);
        model.addAttribute("post", post);

        return "postPage";
    }

    @GetMapping("/post")
    public String getPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @PostMapping("/create")
    public String createProduct(Post post, Model model) {
        Post createdPost = postRepository.save(post);

        model.addAttribute("post", createdPost);
        return "redirect:/posts/" + createdPost.getPost_id();
    }
}
