package com.example.demo.models.Enums;

public enum UserRoleTypesEnum {
    USER(0),
    ADMIN(1);

    private final int value;

    UserRoleTypesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}