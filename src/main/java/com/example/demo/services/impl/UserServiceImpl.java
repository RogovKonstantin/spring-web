package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.UserRoleRepository;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.web.views.UserCreationMV;
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
    public void addUser(String firstName, String lastName, String username, String password) {
        UserCreationMV userCreation = new UserCreationMV(firstName, lastName, username, password);
        if (!this.validationUtil.isValid(userCreation)) {

            this.validationUtil
                    .violations(userCreation)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            User user = modelMapper.map(userCreation, User.class);
            user.setRole(userRoleRepository.findByRole(Role.USER));
            user.setActive(true);
            user.setImageUrl("blank");
            userRepository.saveAndFlush(user);

        }
    }

    @Override
    public List<UserMV> getAllActiveUsers() {
        return userRepository.findAllActiveUsers();
    }

    @Override
    public List<UserMV> getAllUnActiveUsers() {
        return userRepository.findAllUnActiveUsers();
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
