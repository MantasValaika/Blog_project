package com.example.blog.controller;

import com.example.blog.repository.entity.User;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/public/register")
@RequiredArgsConstructor
public class UserPublicController {

    private final UserService userService;

    @GetMapping
    public String getUserRegisterForm(Model model) {
        return "userRegisterForm";
    }

    @PostMapping("/createUser")
    public String createUser(
            @Valid @ModelAttribute User user,
            BindingResult errors,
            final RedirectAttributes redirectAttributes,
            Model model) {
        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", errors);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/public/register";
        }

        User newUser = userService.create(user);

        model.addAttribute("user", newUser);
        return "redirect:/login";
    }

    @ModelAttribute("user")
    public User populateEmptyUser() {
        return new User();
    }
}
