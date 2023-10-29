package com.example.demo.web.views;

import com.example.demo.models.Model;

import java.util.Set;

public class BrandModelView {
    private String name;
    private Set<Model> models;

    public BrandModelView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "BrandModelView{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
