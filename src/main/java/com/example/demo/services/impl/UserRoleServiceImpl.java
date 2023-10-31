package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repos.UserRoleRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.DTOS.UserRoleDto;
import com.example.demo.services.UserRoleService;
import com.example.demo.util.ValidationUtil;
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

    @Override
    public void updateUserRole(User user, UserRole userRole) {

        if (user.getRole().getId().toString().equals(userRole.getId().toString())) {
            System.out.println(user.getUsername() + " is already " + userRole);
        } else {
            user.setRole(userRole);
            userRepository.save(user);
            userRoleRepository.save(userRole);
            System.out.println(user.getUsername() + " is now " + user.getRole().toString());
        }
    }

    @Override
    public UserRoleDto getByRole(Role role) {
        return modelMapper.map(userRoleRepository.findByRole(role), UserRoleDto.class);
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
