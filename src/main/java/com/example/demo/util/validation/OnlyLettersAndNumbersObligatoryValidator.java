package com.example.demo.util.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OnlyLettersAndNumbersObligatoryValidator implements ConstraintValidator<OnlyLettersAndNumbersObligatory, String> {
    @Override
    public void initialize(OnlyLettersAndNumbersObligatory constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]*$");
    }
}
