package com.example.demo.services.DTOS.defaultDTOS;


import com.example.demo.models.Enums.VehicleTypesEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModelDto {
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String name;
    private VehicleTypesEnum category;
    private int startYear;
    private int endYear;
    private String imageUrl;
    private BrandDto brand;

    public ModelDto(UUID id, String name, VehicleTypesEnum category, int startYear, int endYear, String imageUrl, BrandDto brand) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
        this.brand = brand;
    }

    public ModelDto() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ModelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                ", brand=" + brand +
                '}';
    }
}
