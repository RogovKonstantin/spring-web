package com.example.demo.web.views;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Optional;

public class FiltersInputMV {
    private Optional<String> engines;
    private Optional<String> transmissions;
    private Optional<Integer> minYear;
    private Optional<Integer> maxYear;
    private Optional<Integer> minPrice;
    private Optional<Integer> maxPrice;

    public FiltersInputMV(Optional<String> engines, Optional<String> transmissions, Optional<Integer> minYear, Optional<Integer> maxYear, Optional<Integer> minPrice, Optional<Integer> maxPrice) {
        this.engines = engines;
        this.transmissions = transmissions;
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public FiltersInputMV() {
    }

    public Optional<String> getEngines() {
        return engines;
    }

    public void setEngines(Optional<String> engines) {
        this.engines = engines;
    }

    public Optional<String> getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(Optional<String> transmissions) {
        this.transmissions = transmissions;
    }


    public Optional<Integer> getMinYear() {
        return minYear;
    }

    public void setMinYear(Optional<Integer> minYear) {
        this.minYear = Optional.of(minYear.orElse(1900));
    }

    public Optional<Integer> getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Optional<Integer> maxYear) {
        this.maxYear = Optional.of(maxYear.orElse(2023));
    }


    public Optional<Integer> getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Optional<Integer> minPrice) {
        this.minPrice = Optional.of(minPrice.orElse(0));
    }

    public Optional<Integer> getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Optional<Integer> maxPrice) {
        this.maxPrice = Optional.of(maxPrice.orElse(1000000000));
    }

    @Override
    public String toString() {
        return "FiltersInputMV{" +
                "engines=" + engines +
                ", transmissions=" + transmissions +
                ", minYear=" + minYear +
                ", maxYear=" + maxYear +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}
