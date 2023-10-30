package com.example.demo.services.DTOS.defaultDTOS;


import com.example.demo.constants.Enums.Role;

import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private Role role;

    public UserRoleDto(Role role) {

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
