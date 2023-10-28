package com.example.demo.models.Enums;

public enum EngineTypesEnum {
    GASOLINE(0),
    DIESEL(1),
    ELECTRIC(2),
    HYBRID(3);

    private final int value;

    EngineTypesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
