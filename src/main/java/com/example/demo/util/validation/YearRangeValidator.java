package com.example.demo.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearRangeValidator implements ConstraintValidator<YearRange, Integer> {

    private int minYear;
    private int maxYear;

    @Override
    public void initialize(YearRange constraintAnnotation) {
        this.minYear = 1900;
        this.maxYear = Integer.parseInt(String.valueOf(Year.now()));
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        return year >= minYear && year <= maxYear;
    }
}
