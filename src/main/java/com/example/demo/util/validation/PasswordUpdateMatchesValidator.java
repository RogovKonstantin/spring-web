package com.example.demo.util.validation;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.impl.AppUserDetailsService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;

public class PasswordUpdateMatchesValidator implements ConstraintValidator<PasswordUpdateMatches, String> {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;



    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username);
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }




}
