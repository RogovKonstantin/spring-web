package com.example.demo.web.views;

import com.example.demo.util.validation.UniqueBrandName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BrandCreationMV {
    @UniqueBrandName
    private String name;

    public BrandCreationMV(String name) {
        this.name = name;
    }

    public BrandCreationMV() {
    }
    @NotEmpty
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
