package com.example.demo.web.views;

import com.example.demo.constants.Enums.VehicleTypesEnum;

import java.time.LocalDateTime;

public class OfferWithDateAndUserMV {

    private String description;
    private int price;
    private int mileage;

    private int year;

    private VehicleTypesEnum category;
    private String modelName;
    private LocalDateTime created;
    private String username;


    public OfferWithDateAndUserMV(String description, int price, int mileage, int year, VehicleTypesEnum category, String modelName, LocalDateTime created,String username) {
        this.description = description;
        this.price = price;
        this.mileage = mileage;
        this.year = year;
        this.category = category;
        this.modelName = modelName;
        this.created=created;
        this.username=username;
    }

    public OfferWithDateAndUserMV() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "OfferWithDateAndUserMV{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", year=" + year +
                ", category=" + category +
                ", modelName='" + modelName + '\'' +
                ", created=" + created +
                ", username='" + username + '\'' +
                '}';
    }
}
