package com.example.demo.models.BaseModels;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class IdDateTimeModel extends IdModel {

    protected LocalDateTime created;
    protected LocalDateTime modified;

    public IdDateTimeModel(UUID id,LocalDateTime created,LocalDateTime modified) {
        super(id);
        this.created=created;
        this.modified=modified;

    }
    protected IdDateTimeModel(){}

    @CreationTimestamp
    @Column(name="created", nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    @UpdateTimestamp
    @Column(name="modified", nullable = false)
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }












}
