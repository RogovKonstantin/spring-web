package com.example.demo.web.views;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.Offer;

import java.util.Set;

public class UserMV {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private Role role;

    public UserMV(String username, String firstName, String lastName, String imageUrl,Role role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.role=role;
    }



    public UserMV() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserMV{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", role=" + role +
                '}';
    }
}
