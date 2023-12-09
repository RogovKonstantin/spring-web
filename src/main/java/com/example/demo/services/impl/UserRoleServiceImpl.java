package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.UserRoleRepository;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.DTOS.UserRoleDto;
import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.util.validation.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;



    @Autowired
    UserRoleServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveAllUserRoles(List<UserRole> userRoles) {
        userRoleRepository.saveAll(userRoles);
    }

    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    /*@Override
    public void updateUserRoleToUSER(String username) {
        UserDto userDto = userService.getByUsername(username);
        if (userDto.getRole().getId() == this.getByRole(Role.USER).getId()) {
            System.out.println(username + " is already User");
        } else {
            userDto.setRole(this.getByRole(Role.USER));
            User user = modelMapper.map(userDto, User.class);
            userRepository.saveAndFlush(user);
            System.out.println(username + " is now User");
        }
    }
    @Override
    public void updateUserRoleToADMIN(String username) {
        UserDto userDto = userService.getByUsername(username);
        if (userDto.getRole().getId() == this.getByRole(Role.ADMIN).getId()) {
            System.out.println(username + " is already Admin");
        } else {
            userDto.setRole(this.getByRole(Role.ADMIN));
            User user = modelMapper.map(userDto, User.class);
            userRepository.saveAndFlush(user);
            System.out.println(username + " is now Admin");
        }
    }*/

    @Override
    public UserRole getByRole(Role role) {
        return userRoleRepository.findByRole(role);
    }


    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((userUserRole) -> modelMapper.map(userUserRole, UserRoleDto.class)).collect(Collectors.toList());
    }



    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


}
