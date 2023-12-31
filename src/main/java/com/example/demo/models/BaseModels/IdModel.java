package com.example.demo.models.BaseModels;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class IdModel {

    protected UUID id;

    public IdModel(UUID id) {
        this.id = id;
    }

    protected IdModel() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
