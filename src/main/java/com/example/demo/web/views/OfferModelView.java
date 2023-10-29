package com.example.demo.web.views;

import java.time.LocalDateTime;

public class OfferModelView {
    private String description;
    private String engine;
    private int mileage;
    private int price;
    private String transmission;
    private int year;
    private String seller;
    private String model;
    private String brand;
    private String imageUrl;
    private LocalDateTime dateCreated;

    public OfferModelView() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "OfferModelView{" +
                "description='" + description + '\'' +
                ", engine='" + engine + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission='" + transmission + '\'' +
                ", year=" + year +
                ", seller='" + seller + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", image='" + imageUrl + '\'' +
                ", Creation date=" + dateCreated.getYear() + " " + dateCreated.getMonth() + " " + dateCreated.getDayOfMonth() +
                '}';
    }
}

