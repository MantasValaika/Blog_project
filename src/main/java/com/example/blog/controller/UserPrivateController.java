package com.example.blog.controller;

import com.example.blog.repository.entity.Post;
import com.example.blog.repository.entity.User;
import com.example.blog.service.PostService;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/private/users")
@RequiredArgsConstructor
public class UserPrivateController {

    private final UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUserInfo(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "userName", required = false) boolean showUserInfo,
            Model model) {

        User user = userService.findById(id);

        model.addAttribute("userName", showUserInfo);
        model.addAttribute("user", user);
        return "userPage";
    }
}
