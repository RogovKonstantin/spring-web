package com.example.demo.web.views;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class OfferCreationMV {
    private String seller;
    private String model;
    private int year;
    private int price;
    private int mileage;
    private String transmissionType;
    private String engineType;
    private String description;
    private String imageUrl;

    public OfferCreationMV(String seller,  String model, int year, int price, int mileage, String transmissionType, String engineType, String imageUrl, String description) {
        this.seller = seller;

        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public OfferCreationMV() {
    }

    @NotNull
    @NotEmpty
    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }



    @NotNull
    @NotEmpty
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    @Min(1920)
    @Max(value = 2023)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @NotNull
    @Min(1)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @NotNull
    @Min(1)
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    @NotNull
    @NotEmpty
    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
    @NotNull
    @NotEmpty
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    @NotNull
    @NotEmpty
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
