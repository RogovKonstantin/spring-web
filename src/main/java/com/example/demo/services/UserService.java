package com.example.demo.services;

import com.example.demo.services.DTOS.ActiveUsersRolesDto;
import com.example.demo.services.DTOS.defaultDTOS.UserDto;
import com.example.demo.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void saveAllUsers(List<User> users);

    void saveUser(User user);

    List<ActiveUsersRolesDto> getAllActiveClients();


    void deleteUser(UserDto userDto);

    void deleteUserById(UUID id);

    UserDto createUser(UserDto userDto);

    void updateUsername(UserDto userDto, String newUsername);



    List<UserDto> getAll();
}
