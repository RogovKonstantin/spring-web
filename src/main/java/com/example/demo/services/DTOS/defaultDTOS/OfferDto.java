package com.example.demo.services.DTOS.defaultDTOS;


import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;

import java.time.LocalDateTime;
import java.util.UUID;


public class OfferDto {
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String description;
    private EngineTypesEnum engine;
    private int mileage;
    private int price;
    private String imageUrl;

    private TransmissionTypesEnum transmission;
    private int year;
    private UserDto seller;

    private ModelDto model;

    public OfferDto(String description, EngineTypesEnum engine, int mileage, int price, String imageUrl, TransmissionTypesEnum transmission, int year, UserDto seller, ModelDto model) {
        this.description = description;
        this.engine = engine;
        this.mileage = mileage;
        this.price = price;
        this.imageUrl = imageUrl;
        this.transmission = transmission;
        this.year = year;
        this.seller = seller;
        this.model = model;
    }

    public OfferDto(UUID id, String description, EngineTypesEnum engine, int mileage, int price, String imageUrl, TransmissionTypesEnum transmission, int year, UserDto seller, ModelDto model) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.mileage = mileage;
        this.price = price;
        this.imageUrl = imageUrl;
        this.transmission = transmission;
        this.year = year;
        this.seller = seller;
        this.model = model;
    }

    public OfferDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineTypesEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineTypesEnum engine) {
        this.engine = engine;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TransmissionTypesEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionTypesEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", engine=" + engine +
                ", mileage=" + mileage +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                '}';
    }
}
