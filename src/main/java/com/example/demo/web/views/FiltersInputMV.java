package com.example.demo.web.views;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Objects;

public class FiltersInputMV {
    private String engines;
    private String transmissions;
    private Integer minYear;
    private Integer maxYear;
    private Integer minPrice;
    private Integer maxPrice;


    public FiltersInputMV(String engines, String transmissions, Integer minYear, Integer maxYear, Integer minPrice, Integer maxPrice) {
        this.engines = engines;
        this.transmissions = transmissions;
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public FiltersInputMV() {
    }


    public String getEngines() {
        return engines;
    }

    public void setEngines(String engines) {
        this.engines = engines;
    }

    public String getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(String transmissions) {
        this.transmissions = transmissions;
    }
    @Min(1900)
    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = Objects.requireNonNullElse(minYear, 1900);
    }
    @Min(1900)
    @Max(2023)
    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = Objects.requireNonNullElse(maxYear, 2023);
    }
    @Min(0)
    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = Objects.requireNonNullElse(minPrice, 0);
    }
    @Min(0)
    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = Objects.requireNonNullElse(maxPrice, 100000000);
    }

    @Override
    public String toString() {
        return "FiltersInputMV{" +
                "engines='" + engines + '\'' +
                ", transmissions='" + transmissions + '\'' +
                ", minYear=" + minYear +
                ", maxYear=" + maxYear +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}
