package com.example.demo.web.controllers;


import com.example.demo.services.UserService;
import com.example.demo.web.views.UserCreationMW;
import com.example.demo.web.views.UserModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    @GetMapping("")
    public String allUsers(Model model) {
        List<UserModelView> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        userList.forEach(System.out::println);
        return "all-users.html";

    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUserByUserName(username);
        return "all-users.html";
    }

    @PostMapping("")
    public String createUser(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String username,@RequestParam String password) {
        userService.addUser(firstName,lastName,username,password);
        return "all-users.html";
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
