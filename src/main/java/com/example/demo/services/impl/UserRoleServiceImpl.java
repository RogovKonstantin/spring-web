package com.example.demo.services.impl;

import com.example.demo.services.DTOS.defaultDTOS.UserRoleDto;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.UserRoleRepository;
import com.example.demo.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    @Autowired
    UserRoleServiceImpl(ModelMapper modelMapper, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void saveAllUserRoles(List<UserRole> userRoles) {
        userRoleRepository.saveAll(userRoles);
    }

    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public void updateUserRole(User user, UserRole role) {

        if (user.getRole().getId().toString().equals(role.getId().toString())) {
            System.out.println(user.getUsername() + " is already " + role);
        } else {
            user.setRole(role);
            userRepository.save(user);
            userRoleRepository.save(role);
            System.out.println(user.getUsername() + " is now " + user.getRole().toString());
        }
    }


    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((userRole) -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }


}