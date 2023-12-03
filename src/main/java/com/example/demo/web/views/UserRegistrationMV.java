package com.example.demo.web.views;


import com.example.demo.util.validation.LettersAndDotsOnly;
import com.example.demo.util.validation.LettersOnly;
import com.example.demo.util.validation.OnlyLettersAndNumbersObligatory;
import com.example.demo.util.validation.UniqueUsername;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserRegistrationMV {

    @UniqueUsername
    @LettersAndDotsOnly
    private String username;
    @LettersOnly
    private String firstName;
    @LettersOnly
    private String lastName;
    @OnlyLettersAndNumbersObligatory
    private String password;

    public UserRegistrationMV() {
    }

    @NotNull
    @NotEmpty(message = "Username cannot be empty")
    @Length(min = 3, message = "Username must contain at least 3 symbols")
    @Length(max = 15, message = "Username can not be longer than 15 symbols")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @NotEmpty(message = "First name cannot be empty")
    @Length(min = 2, message = "First name must contain at least 2 symbols")
    @Length(max = 15, message = "First name can not be longer than 15 symbols")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @NotEmpty(message = "Last name cannot be empty")
    @Length(min = 2, message = "Last name must contain at least 2 symbols")
    @Length(max = 15, message = "Last name can not be longer than 15 symbols")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    @Length(min = 5, message = "Password must contain at least 5 symbols")
    @Length(max = 15, message = "Password can not be longer than 15 symbols")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}