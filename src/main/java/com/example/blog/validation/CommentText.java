package com.example.blog.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommentTextValidator.class)
public @interface CommentText {

    String message() default "{commentText.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
