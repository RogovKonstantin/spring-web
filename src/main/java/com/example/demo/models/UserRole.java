package com.example.demo.models;


import com.example.demo.models.BaseModels.IdModel;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole extends IdModel {

    private com.example.demo.constants.Enums.Role role;
    private Set<User> users;

    public UserRole(com.example.demo.constants.Enums.Role role) {
        this.role = role;
    }
    public UserRole() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name", nullable = false)
    public com.example.demo.constants.Enums.Role getRole() {
        return role;
    }

    public void setRole(com.example.demo.constants.Enums.Role role) {
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
