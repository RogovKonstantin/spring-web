package com.example.demo.constants.Enums;

public enum VehicleTypesEnum {
    CAR(0),
    BUS(1),
    TRUCK(2),
    MOTORCYCLE(3);
    private final int value;

    VehicleTypesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
