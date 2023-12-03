package com.example.demo.util.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class NoNumbersValidator implements ConstraintValidator<NoNumbers, String> {
    @Override
    public void initialize(NoNumbers constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.matches(".*\\d+.*");
    }
}
