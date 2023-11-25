package com.example.demo.web.views;

public class MinimalOfferInfoMV {
    private int price;
    private int mileage;
    private int year;
    private String modelName;
    private String brandName;

    public MinimalOfferInfoMV(int price, int mileage, int year, String modelName,String brandName) {
        this.price = price;
        this.mileage = mileage;
        this.year = year;
        this.modelName = modelName;
        this.brandName=brandName;
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
