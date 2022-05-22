package com.example.blog.controller;

import com.example.blog.exeption.PostNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public String handleException() {
        log.error("Looking for post that does not exict");
        return "redirect:/posts";
    }
}
