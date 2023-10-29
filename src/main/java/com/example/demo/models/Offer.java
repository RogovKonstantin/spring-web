package com.example.demo.models;


import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.models.BaseModels.IdDateTimeUrlModel;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends IdDateTimeUrlModel {

    private String description;
    private EngineTypesEnum engine;
    private int mileage;
    private int price;
    private TransmissionTypesEnum transmission;
    private int year;
    private User seller;
    private Model model;

    public Offer(String description, EngineTypesEnum engine, int mileage, int price, String url, TransmissionTypesEnum transmission, int year, User seller, Model model) {
        this.description = description;
        this.engine = engine;
        this.mileage = mileage;
        this.price = price;
        this.setImageUrl(url);
        this.transmission = transmission;
        this.year = year;
        this.seller = seller;
        this.model = model;
    }

    public Offer() {}

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "engine", nullable = false)
    public EngineTypesEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineTypesEnum engine) {
        this.engine = engine;
    }

    @Column(name = "mileage", nullable = false)
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transmission", nullable = false)
    public TransmissionTypesEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionTypesEnum transmission) {
        this.transmission = transmission;
    }

    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", seller=" + seller +
                ", model=" + model +
                ", imageUrl='" + imageUrl + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", id=" + id +
                '}';
    }
}
