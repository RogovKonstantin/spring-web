package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.UserRoleRepository;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.UserService;
import com.example.demo.util.validation.ValidationUtil;
import com.example.demo.web.views.UserRegistrationMV;
import com.example.demo.web.views.UserMV;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private ValidationUtil validation;

    @Autowired
    UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveAllUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.saveAndFlush(user);
    }


    @Transactional
    @Override
    public void deleteUserByUserName(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public void createUser(UserDto userDto) {
        this.userRepository.saveAndFlush(this.modelMapper.map(userDto, User.class));

    }

    @Override
    public void updateUsername(String currentUserName, String newUsername) {
        UserDto userDto = this.getByUsername(currentUserName);
        userDto.setUsername(newUsername);
        if (!this.validationUtil.isValid(userDto)) {
            this.validationUtil
                    .violations(userDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {

            System.out.println(userDto);
            userRepository.saveAndFlush(modelMapper.map(userDto, User.class));
        }
    }


    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<UserMV> getAllUsers() {
        return this.getAll().stream().map((user) -> modelMapper.map(user, UserMV.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserDto.class);
    }



    @Override
    public List<UserMV> getAllActiveUsers() {
        return userRepository.findAllActiveUsers();
    }

    @Override
    public List<UserMV> getAllUnActiveUsers() {
        return userRepository.findAllUnActiveUsers();
    }

    @Override
    public UserMV getUserMVByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void registerUser(UserRegistrationMV newUser) {
        if (!this.validation.isValid(newUser)) {
            this.validation
                    .violations(newUser)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal argument");
        } else {
            User newUserModel = modelMapper.map(newUser, User.class);
            newUserModel.setRole(userRoleRepository.findByRole(Role.USER));
            newUserModel.setActive(true);
            newUserModel.setImageUrl("blank");
            userRepository.saveAndFlush(newUserModel);
        }
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
    @Autowired
    public void setValidation(ValidationUtil validation) {
        this.validation = validation;
    }
}
