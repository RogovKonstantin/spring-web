package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.web.views.PasswordUpdateMV;
import com.example.demo.web.views.UserMV;
import com.example.demo.web.views.UserRegistrationMV;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private UserRepository userRepository;
    private UserRoleService userRoleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public UserMV getUserMVByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public UserMV updatePassword(PasswordUpdateMV passwordUpdateMV, String username) {
        User user = userRepository.findByUsername(username);
        System.out.println(passwordUpdateMV.getNewPassword());
        user.setPassword(passwordEncoder.encode(passwordUpdateMV.getNewPassword()));
        userRepository.saveAndFlush(user);
        return modelMapper.map(user,UserMV.class);
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
