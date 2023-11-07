package com.example.demo.web.views;

public class BrandMV {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "BrandModelView{" +
                "name='" + name + '\'' +
                '}';
    }
}
