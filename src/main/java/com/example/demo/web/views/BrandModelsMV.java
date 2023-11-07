package com.example.demo.web.views;

import com.example.demo.constants.Enums.VehicleTypesEnum;

public class BrandModelsMV {
    private VehicleTypesEnum category;
    private String modelName;
    private String brandName;
    private int endYear;

    public BrandModelsMV(VehicleTypesEnum category, String modelName, String brandName, int endYear) {
        this.category = category;
        this.modelName = modelName;
        this.brandName = brandName;
        this.endYear = endYear;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "BrandModelsMV{" +
                "category=" + category +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", endYear=" + endYear +
                '}';
    }
}
