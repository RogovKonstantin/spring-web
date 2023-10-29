package com.example.demo.models;


import com.example.demo.constants.Enums.UserRoleTypesEnum;
import com.example.demo.models.BaseModels.IdModel;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole extends IdModel {

    private UserRoleTypesEnum role;
    private List<User> users;

    public UserRole(UserRoleTypesEnum role) {
        this.role = role;
    }
    public UserRole() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", orphanRemoval = false)
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name", nullable = false)
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
                ", users=" + users +
                ", id=" + id +
                '}';
    }
}
