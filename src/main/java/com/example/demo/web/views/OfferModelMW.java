package com.example.demo.web.views;

import com.example.demo.constants.Enums.VehicleTypesEnum;

public class OfferModelMW {

    private String description;
    private int price;
    private int mileage;

    private int year;

    private VehicleTypesEnum category;
    private String modelName;

    public OfferModelMW(String description, int price, int mileage, int year, VehicleTypesEnum category, String modelName) {
        this.description = description;
        this.price = price;
        this.mileage = mileage;
        this.year = year;
        this.category = category;
        this.modelName = modelName;
    }

    public OfferModelMW() {
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

    @Override
    public String toString() {
        return "OfferModelMW{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", year=" + year +
                ", category=" + category +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
