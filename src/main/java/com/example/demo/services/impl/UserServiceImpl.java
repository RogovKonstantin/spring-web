package com.example.demo.services.impl;

import com.example.demo.services.DTOS.ActiveUsersRolesDto;
import com.example.demo.services.DTOS.defaultDTOS.UserDto;
import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Autowired
    UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper=modelMapper;
        this.userRepository=userRepository;
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
    public List<ActiveUsersRolesDto> getAllActiveClients() {
        return userRepository.getAllActiveClients().stream().map((u) -> modelMapper.map(u, ActiveUsersRolesDto.class)).collect(Collectors.toList());
    }



    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
        System.out.println("User " + userDto.getUsername() + " deleted");
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
        System.out.println("User (id= "+id+") deleted ");
    }
    @Override
    public UserDto createUser(UserDto user) {
        User user_model = modelMapper.map(user, User.class);
        return modelMapper.map(userRepository.save(user_model), UserDto.class);
    }

    @Override
    public void updateUsername(UserDto userDto, String newUsername) {
        User user = modelMapper.map(userDto,User.class);
        String oldUserName= user.getUsername();
        user.setUsername(newUsername);
        userRepository.save(user);
        System.out.println(oldUserName+" changed to "+ newUsername);

    }



    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

    }


}