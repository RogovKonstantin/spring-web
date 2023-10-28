package com.example.demo.services.DTOS;

import com.example.demo.services.DTOS.defaultDTOS.UserRoleDto;

public class ActiveUsersRolesDto {

    private Boolean isActive;
    private String username;
    private UserRoleDto role;


    public ActiveUsersRolesDto(Boolean isActive, String username, UserRoleDto role) {
        this.isActive = isActive;
        this.username = username;
        this.role = role;
    }

    public ActiveUsersRolesDto() {
    }


    @Override
    public String toString() {
        return "{" +
                "is active=" + isActive +
                ", username='" + username + '\'' +
                ", role=" + role.getRole() +
                '}' + '\n';
    }
}
