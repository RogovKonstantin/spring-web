package com.example.demo.util.validation;

import com.example.demo.repos.BrandRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueBrandNameValidator implements ConstraintValidator<UniqueBrandName, String> {

    private BrandRepository brandRepository;


    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return brandRepository.findBrandByName(name).isEmpty();
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
