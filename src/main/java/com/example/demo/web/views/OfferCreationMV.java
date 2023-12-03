package com.example.demo.web.views;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class OfferCreationMV {
    private String username;
    private String brandName;
    private String modelName;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
