package com.example.blog.Controller;

import com.example.blog.exeption.PostNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ PostNotFoundException.class})
    public final String handleException(Exception ex, WebRequest request) {
        if (ex instanceof  PostNotFoundException) {
            return "postNotFound";
        } else {
            return "error";
        }
    }
}
