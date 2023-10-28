package com.example.demo.services.DTOS;

import com.example.demo.models.Enums.VehicleTypesEnum;

public class OffersModelsByUserStateDto {
    private String username;
    private String description;
    private Integer price;
    private Integer mileage;
    private Integer year;
    private VehicleTypesEnum category;
    private String name;



    public OffersModelsByUserStateDto(String username, String description, Integer price, Integer mileage, Integer year, VehicleTypesEnum category, String name) {
        this.username = username;
        this.description = description;
        this.price = price;
        this.mileage = mileage;
        this.year = year;
        this.category = category;
        this.name = name;



    }

    public OffersModelsByUserStateDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", year=" + year +
                ", vehicle type=" + category +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}
