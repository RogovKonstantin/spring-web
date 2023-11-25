package com.example.demo.web.controllers;


import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.web.views.UserMV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UserService userService;
    private UserRoleService userRoleService;

    @GetMapping("")
    public String allUsers(Model model) {
        List<UserMV> allUsersList = userService.getAllUsers();
        model.addAttribute("allUsersList", allUsersList);
        allUsersList.forEach(System.out::println);
        return "all-users.html";
    }

    @GetMapping("/active")
    public String allActiveUsers(Model model) {
        List<UserMV> allActiveUsersList = userService.getAllActiveUsers();
        model.addAttribute("allActiveUsersList", allActiveUsersList);
        allActiveUsersList.forEach(System.out::println);
        return "all-users.html";
    }

    @GetMapping("/unactive")
    public String allUnActiveUsers(Model model) {
        List<UserMV> allUnActiveUsersList = userService.getAllUnActiveUsers();
        model.addAttribute("allUnActiveUsersList", allUnActiveUsersList);
        allUnActiveUsersList.forEach(System.out::println);
        return "all-users.html";
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUserByUserName(username);
        return "all-users.html";
    }

    @PostMapping("")
    public String createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, @RequestParam String password) {
        userService.addUser(firstName, lastName, username, password);
        return "all-users.html";
    }

    @PutMapping("/username-update")
    public String updateUserName(@RequestParam String currentUsername, @RequestParam String newUsername) {
        userService.updateUsername(currentUsername, newUsername);
        return "all-users.html";
    }

    @PutMapping("{username}/update-role-user")
    public String updateRoleUser(@PathVariable String username) {
        userRoleService.updateUserRoleToUSER(username);
        return "all-users.html";
    }

    @PutMapping("{username}/update-role-admin")
    public String updateRoleAdmin(@PathVariable String username) {
        userRoleService.updateUserRoleToADMIN(username);
        return "all-users.html";
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
