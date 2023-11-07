package com.example.demo.web.views;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BrandCreationMV {
    private String name;

    public BrandCreationMV(String name) {
        this.name = name;
    }
    @NotNull
    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
