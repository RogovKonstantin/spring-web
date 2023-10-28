package com.example.demo.services;


import com.example.demo.services.DTOS.defaultDTOS.UserRoleDto;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;

import java.util.List;

public interface UserRoleService {

    void saveAllUserRoles(List<UserRole> userRoles);

    void saveUserRole(UserRole userRole);


    List<UserRoleDto> getAll();

    void updateUserRole(User user, UserRole role);
}
