package com.example.demo.web.views;

import java.util.UUID;

public class MinimalOfferInfoMV {
    private int price;
    private int mileage;
    private int year;
    private String modelName;
    private String brandName;
    private UUID id;

    public MinimalOfferInfoMV(int price, int mileage, int year, String modelName,String brandName,UUID id) {
        this.price = price;
        this.mileage = mileage;
        this.year = year;
        this.modelName = modelName;
        this.brandName=brandName;
        this.id=id;
    }



    public MinimalOfferInfoMV() {

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MinimalOfferInfoMV{" +
                "price=" + price +
                ", mileage=" + mileage +
                ", year=" + year +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
