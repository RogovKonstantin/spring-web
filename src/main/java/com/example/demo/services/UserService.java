package com.example.demo.services;

import com.example.demo.models.User;

import com.example.demo.services.DTOS.UserDto;
import com.example.demo.web.views.UserRegistrationMV;
import com.example.demo.web.views.UserMV;

import java.util.List;

public interface UserService {

    void saveAllUsers(List<User> users);

    void saveUser(User user);

    void addUser(UserDto userDto);





    void deleteUserByUserName(String username);

    void createUser(UserDto userDto);

    void updateUsername(String currentUsername, String newUserName);

    List<UserDto> getAll();

    List<UserMV> getAllUsers();
    UserDto getByUsername(String username);


    List<UserMV> getAllActiveUsers();
    List<UserMV> getAllUnActiveUsers();
    UserMV getUserMVByUsername(String username);

    void registerUser(UserRegistrationMV newUser);
}
