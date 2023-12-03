package com.example.demo.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LettersAndDotsOnlyValidator implements ConstraintValidator<LettersAndDotsOnly, String> {
    @Override
    public void initialize(LettersAndDotsOnly constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("^[a-zA-Z.]*$");
    }
}
