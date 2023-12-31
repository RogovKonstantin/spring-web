package com.example.demo.models;

import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.BaseModels.IdDateTimeUrlModel;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends IdDateTimeUrlModel {

    private String name;
    private VehicleTypesEnum category;
    private int startYear;
    private int endYear;
    private Brand brand;
    private Set<Offer> offers;

    public Model(String name, VehicleTypesEnum category, String imageUrl, int startYear, int endYear, Brand brand) {
        this.name = name;
        this.category = category;
        this.setImageUrl(imageUrl);
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
    }

    public Model() {}

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category", nullable = false)
    public VehicleTypesEnum getCategory() {
        return category;
    }

    public void setCategory(VehicleTypesEnum category) {
        this.category = category;
    }

    @Column(name = "start_year", nullable = false)
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(name = "end_year", nullable = false)
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
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
