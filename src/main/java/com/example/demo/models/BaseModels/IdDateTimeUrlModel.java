package com.example.demo.models.BaseModels;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class IdDateTimeUrlModel extends IdDateTimeModel {

    protected String imageUrl;

    public IdDateTimeUrlModel(UUID id, LocalDateTime created, LocalDateTime modified, String imageUrl) {
        super(id, created, modified);
        this.imageUrl = imageUrl;
    }

    protected IdDateTimeUrlModel() {}
    @Column(name="image_url",nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
