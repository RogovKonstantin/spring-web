package com.example.demo.services.impl;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.repos.UserRoleRepository;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.UserService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.web.views.UserCreationMW;
import com.example.demo.web.views.UserModelView;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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


    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
        System.out.println("User " + userDto.getUsername() + " deleted");
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
        System.out.println("User (id= " + id + ") deleted ");
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
    public void updateUsername(UserDto userDto, String newUsername) {
        User user = modelMapper.map(userDto, User.class);
        String oldUserName = user.getUsername();
        user.setUsername(newUsername);
        userRepository.save(user);
        System.out.println(oldUserName + " changed to " + newUsername);

    }


    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<UserModelView> getAllUsers() {
        return this.getAll().stream().map((user) -> modelMapper.map(user, UserModelView.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void addUser(String firstName, String lastName, String username, String password) {
        UserCreationMW userCreation = new UserCreationMW(firstName, lastName, username, password);
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

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
}
