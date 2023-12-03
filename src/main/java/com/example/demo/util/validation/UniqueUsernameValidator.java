package com.example.demo.util.validation;

import com.example.demo.repos.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private UserRepository userRepository;


    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return userRepository.findUserByUsername(name).isEmpty();
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}