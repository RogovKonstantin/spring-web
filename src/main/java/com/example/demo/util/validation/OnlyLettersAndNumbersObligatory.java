package com.example.demo.util.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = OnlyLettersAndNumbersObligatoryValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyLettersAndNumbersObligatory {
    String message() default "Password must contain only letters and numbers";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

