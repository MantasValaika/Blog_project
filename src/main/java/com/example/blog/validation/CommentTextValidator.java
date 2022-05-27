package com.example.blog.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommentTextValidator implements ConstraintValidator<CommentText, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value.length() > 255) {
            return false;
        }
        return  value.length() <= 255;
    }
}
