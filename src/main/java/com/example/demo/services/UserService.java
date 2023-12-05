package com.example.demo.services;

import com.example.demo.services.DTOS.UserDto;
import com.example.demo.web.views.UserRegistrationMV;
import com.example.demo.web.views.UserMV;

import java.util.List;

public interface UserService {

    void createUser(UserDto userDto);

    UserMV getUserMVByUsername(String username);

    void registerUser(UserRegistrationMV userRegistrationMV);
    UserDto getByUsername(String username);


}
