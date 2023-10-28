package com.example.demo.models;


import com.example.demo.models.BaseModels.IdModel;
import com.example.demo.models.Enums.UserRoleTypesEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "roles")
public class UserRole extends IdModel {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name", nullable = false)
    private UserRoleTypesEnum role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role",orphanRemoval = false)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
    private List<User> users;

    public UserRole(UserRoleTypesEnum role) {
        this.role = role;
    }

    public UserRole() {
    }

    public List<User> getUsers() {
        return users;
    }


    public UserRoleTypesEnum getRole() {
        return role;
    }

    public void setRole(UserRoleTypesEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role=" + role +
                ", id=" + id +
                "} " + super.toString();
    }
}
