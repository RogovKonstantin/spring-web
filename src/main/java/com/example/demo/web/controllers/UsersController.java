package com.example.demo.web.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserRoleService;
import com.example.demo.services.UserService;
import com.example.demo.services.impl.AuthService;
import com.example.demo.web.views.PasswordUpdateMV;
import com.example.demo.web.views.UserMV;
import com.example.demo.web.views.UserRegistrationMV;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;
    private UserRoleService userRoleService;
    private AuthService authService;
    private AuthenticationManager authenticationManager;


    @GetMapping("profile/{username}")
    public String userInfo(@PathVariable String username, Model model, Principal principal) {
        User user = authService.getUser(principal.getName());
        UserMV userDetails = new UserMV(username, user.getFirstName(), user.getLastName(), user.getImageUrl(), user.getRole().getRole(), user.getCreated(), user.getActive());
        model.addAttribute("user", userService.getUserMVByUsername(username));
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("principal", principal);
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
    public String registerUser(@Valid UserRegistrationMV userRegistrationMV, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationModelAttribute", userRegistrationMV);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationModelAttribute", bindingResult);
            return "redirect:/users/register";
        }

        // Register the user
        authService.registerUser(userRegistrationMV);
        authService.authWithHttpServletRequest(request, userRegistrationMV.getUsername(), userRegistrationMV.getPassword());
        // Authenticate the user after successful registration


        return "redirect:/";
    }
    @ModelAttribute("passwordUpdateModelAttribute")
    public PasswordUpdateMV passwordUpdateMV() {
        return new PasswordUpdateMV();
    }
    @PutMapping("/update-password")
    public String changePass(@ModelAttribute PasswordUpdateMV passwordUpdateMV, Model model, Principal principal,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        UserMV userMV = userService.updatePassword(passwordUpdateMV, principal.getName());
        model.addAttribute("userDetails", userMV);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("passwordUpdateModelAttribute", passwordUpdateMV);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.passwordUpdateModelAttribute", bindingResult);
            return "redirect:/users/update-password" + userMV.getUsername();
        }
        return "redirect:/users/profile/" + userMV.getUsername();
    }

    @GetMapping("/login")
    public String loginUser() {
        return "user-login";
    }


    @PostMapping("/login-error")
    public String onFailedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);
        return "redirect:/users/login";
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

}
