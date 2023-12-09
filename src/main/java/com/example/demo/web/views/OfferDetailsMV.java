package com.example.demo.web.views;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.constants.Enums.VehicleTypesEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class OfferDetailsMV {
    private int price;
    private int mileage;
    private int year;
    private String modelName;
    private String brandName;
    private VehicleTypesEnum category;
    private String username;
    private boolean active;
    private String description;
    private LocalDateTime created;
    private TransmissionTypesEnum transmission;
    private EngineTypesEnum engine;
    private UUID id;


    public OfferDetailsMV(int price, int mileage, int year, String modelName, String brandName, VehicleTypesEnum category, String username, boolean active, String description, LocalDateTime created, TransmissionTypesEnum transmission, EngineTypesEnum engine, UUID id) {
        this.price = price;
        this.mileage = mileage;
        this.year = year;
        this.modelName = modelName;
        this.brandName = brandName;
        this.category = category;
        this.username = username;
        this.active = active;
        this.description = description;
        this.created = created;
        this.transmission = transmission;
        this.engine = engine;
        this.id = id;
    }

    public OfferDetailsMV() {

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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public TransmissionTypesEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionTypesEnum transmission) {
        this.transmission = transmission;
    }

    public EngineTypesEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineTypesEnum engine) {
        this.engine = engine;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OfferDetailsMV{" +
                "price=" + price +
                ", mileage=" + mileage +
                ", year=" + year +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", category=" + category +
                ", username='" + username + '\'' +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", transmission=" + transmission +
                ", engine=" + engine +
                '}';
    }
}
