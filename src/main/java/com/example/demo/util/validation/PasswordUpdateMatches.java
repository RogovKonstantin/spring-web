package com.example.demo.util.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = PasswordUpdateMatchesValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordUpdateMatches {
    String message() default "Passwords does not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
