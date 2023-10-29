package com.example.demo.constants.Enums;

public enum TransmissionTypesEnum {
    MANUAL(0),
    AUTOMATIC(1);
    private final int value;

    TransmissionTypesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
