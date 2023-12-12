package com.example.demo.web.views;

import com.example.demo.util.validation.OnlyLettersAndNumbersObligatory;
import com.example.demo.util.validation.PasswordUpdateMatches;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class PasswordUpdateMV {
    @PasswordUpdateMatches
    private String oldPassword;
    @OnlyLettersAndNumbersObligatory
    private String newPassword;

    public PasswordUpdateMV(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public PasswordUpdateMV() {

    }

    @NotNull
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    @Length(min = 5, message = "Password must contain at least 5 symbols")
    @Length(max = 15, message = "Password can not be longer than 15 symbols")
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
