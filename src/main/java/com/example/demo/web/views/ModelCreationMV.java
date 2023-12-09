package com.example.demo.web.views;

import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.util.validation.YearRange;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ModelCreationMV {
    private String name;
    private VehicleTypesEnum category;
    @YearRange
    private int startYear;
    @YearRange
    private int endYear;
    private String brandName;

    public ModelCreationMV(String name, VehicleTypesEnum category, int startYear, int endYear, String brandName) {
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brandName = brandName;
    }

    public ModelCreationMV() {
    }
    @NotNull
    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }
    @NotNull
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @NotNull
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @NotNull
    @NotEmpty
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
