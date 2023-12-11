package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.UserRoleRepository;

import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.web.views.UserRegistrationMV;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;
    private ModelMapper modelMapper;
    private UserRoleService userRoleService;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper,UserRoleService userRoleService,UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.userService=userService;
        this.userRoleService=userRoleService;
    }


    public void registerUser(UserRegistrationMV userRegistrationMV) {
        User user= modelMapper.map(userRegistrationMV, User.class);
        user.setRole(userRoleService.getByRole(Role.ADMIN));
        user.setActive(true);
        user.setImageUrl("blank");
        user.setPassword(passwordEncoder.encode(userRegistrationMV.getPassword()));
        userRepository.saveAndFlush(user);
    }
    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {

        }
    }

    public User getUser(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}