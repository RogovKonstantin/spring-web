package com.example.demo.services;

import com.example.demo.models.User;

import com.example.demo.services.DTOS.UserDto;
import com.example.demo.web.views.UserCreationMW;
import com.example.demo.web.views.UserModelView;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void saveAllUsers(List<User> users);

    void saveUser(User user);

    void addUser(UserDto userDto);



    void deleteUser(UserDto userDto);

    void deleteUserById(UUID id);

    void deleteUserByUserName(String username);

    void createUser(UserDto userDto);

    void updateUsername(UserDto userDto, String newUsername);

    List<UserDto> getAll();

    List<UserModelView> getAllUsers();
    UserDto getByUsername(String username);

    void addUser(String firstName, String lastName, String username, String password);
}
