package com.example.demo.web.views;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserCreationMV {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public UserCreationMV(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "First name must be at least two characters!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Last name must be at least 2 characters!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @NotNull
    @NotEmpty
    @Length(min = 5, message = "Username name must be at least five characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull
    @NotEmpty
    @Length(min = 6, message = "Password must at least six characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
