package com.example.demo.web.views;

import com.example.demo.constants.Enums.VehicleTypesEnum;

import java.util.UUID;

public class MinimalModelInfoMV {
    private String name;
    private VehicleTypesEnum category;
    private int startYear;
    private int endYear;
    private String brand;



    public MinimalModelInfoMV(String name, VehicleTypesEnum category, int startYear, int endYear, String brand) {
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public MinimalModelInfoMV(String name, VehicleTypesEnum category, int startYear, int endYear, UUID id) {
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public MinimalModelInfoMV() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
