package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.web.views.UserMV;
import com.example.demo.web.views.UserRegistrationMV;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private UserRepository userRepository;
    private UserRoleService userRoleService;


    @Autowired
    UserServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserDto.class);
    }


    @Override
    public UserMV getUserMVByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void registerUser(UserRegistrationMV userRegistrationMV) {
        UserDto userDto = modelMapper.map(userRegistrationMV, UserDto.class);
        userDto.setRole(userRoleService.getByRole(Role.USER));
        userDto.setActive(true);
        userDto.setImageUrl("blank");
        this.createUser(userDto);
    }

    @Override
    public void createUser(UserDto userDto) {
        this.userRepository.saveAndFlush(this.modelMapper.map(userDto, User.class));
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

}
