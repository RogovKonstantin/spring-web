package com.example.demo.web.controllers;

import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.web.views.UserRegistrationMV;
import com.example.demo.web.views.UserMV;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @GetMapping("profile/{username}")
    public String userInfo(@PathVariable String username, Model model) {
        UserMV userDetails = userService.getUserMVByUsername(username);
        model.addAttribute("userDetails",userDetails);
        return "user-details";
    }


    @GetMapping("/register")
    public String registerUser() {
        return "user-registration";
    }
    @ModelAttribute("userRegistrationModelAttribute")
    public UserRegistrationMV userRegistrationMV() {
        return new UserRegistrationMV();
    }
    @PostMapping("/register")
    public String registerUser(@Valid UserRegistrationMV userRegistrationMV, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationModelAttribute", userRegistrationMV);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationModelAttribute", bindingResult);
            return "redirect:/users/register";
        }
        userService.registerUser(userRegistrationMV);
        return "redirect:/";
    }






    private UserService userService;
    private UserRoleService userRoleService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
