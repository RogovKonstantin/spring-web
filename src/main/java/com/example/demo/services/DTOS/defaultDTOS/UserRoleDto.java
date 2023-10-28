package com.example.demo.services.DTOS.defaultDTOS;


import com.example.demo.models.Enums.UserRoleTypesEnum;

import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private UserRoleTypesEnum role;

    public UserRoleDto(UUID id, UserRoleTypesEnum role) {
        this.id = id;
        this.role = role;
    }

    public UserRoleDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserRoleTypesEnum getRole() {
        return role;
    }

    public void setRole(UserRoleTypesEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
