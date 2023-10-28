package com.example.demo.models.Enums;

public enum VehicleBrandsEnum {
    FORD(0),
    VOLVO(1),
    MERCEDES(2),
    BMW(3);
    private final int value;

    VehicleBrandsEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
