package com.example.demo.web.views;

import com.example.demo.constants.Enums.Role;
import com.example.demo.models.Offer;

import java.time.LocalDateTime;
import java.util.Set;

public class UserMV {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private Role role;
    private LocalDateTime created;
    private boolean active;

    public UserMV(String username, String firstName, String lastName, String imageUrl, Role role, LocalDateTime created, boolean active) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.role = role;
        this.created = created;
        this.active = active;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserMV{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", role=" + role +
                ", created=" + created +
                '}';
    }
}
