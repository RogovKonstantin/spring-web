package com.example.demo.web.views;

public class OfferCreationMW {
    private final String seller;
    private final String brand;
    private final String model;
    private final int year;
    private final int price;
    private final int mileage;
    private final String transmissionType;
    private final String engineType;
    private String description;
    private String imageUrl;

    public OfferCreationMW(String seller, String brand, String model, int year, int price, int mileage, String transmissionType, String engineType, String imageUrl) {
        this.seller = seller;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
        this.imageUrl=imageUrl;
    }

    public String getSeller() {
        return seller;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
