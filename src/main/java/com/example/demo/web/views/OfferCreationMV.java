package com.example.demo.web.views;

import com.example.demo.util.validation.YearRange;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OfferCreationMV {
    private String username;
    private String brandName;
    private String modelName;
    @YearRange
    private int year;
    private int price;
    private int mileage;
    private String transmission;
    private String engine;
    private String description;
    private String imageUrl;

    public OfferCreationMV(String username, String brandName, String modelName, int year, int price, int mileage, String transmission, String engine, String description, String imageUrl) {
        this.username = username;
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmission = transmission;
        this.engine = engine;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public OfferCreationMV() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull
    @NotEmpty
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    @NotNull
    @NotEmpty
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @NotNull
    @Min(value = 0)
    @Max(value = 1000000000)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @NotNull
    @Min(value = 0)
    @Max(value=2000000)
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @NotNull
    @NotEmpty
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @NotNull
    @NotEmpty
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @NotEmpty
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
