package com.example.demo.models;


import com.example.demo.models.BaseModels.IdDateTimeUrlModel;
import com.example.demo.models.Enums.VehicleTypesEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "models")
public class Model extends IdDateTimeUrlModel {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category", nullable = false)
    private VehicleTypesEnum category;



    @Column(name="start_year", nullable = false)
    private int startYear;

    @Column(name="end_year", nullable = false)
    private int endYear;

    @ManyToOne(optional = false)
    @JoinColumn(name="brand_id", referencedColumnName = "id", nullable = false)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Offer> offers;

    public Model(String name, VehicleTypesEnum category, String imageUrl, int startYear, int endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.setImageUrl(imageUrl);
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }


    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand +
                ", imageUrl='" + imageUrl + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", id=" + id +
                "} " + super.toString();
    }
}
