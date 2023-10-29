package com.example.demo.services.DTOS;

import com.example.demo.services.DTOS.defaultDTOS.BrandDto;
import com.example.demo.services.DTOS.defaultDTOS.ModelDto;
import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;

public class OffersByBrandAndVtypeDto {
    private String description;
    private EngineTypesEnum engineTypesEnum;
    private Integer mileage;
    private Integer price;
    private TransmissionTypesEnum transmissionTypesEnum;
    private Integer year;

    private ModelDto model;

    public OffersByBrandAndVtypeDto(String description, EngineTypesEnum engineTypesEnum, Integer mileage, Integer price, TransmissionTypesEnum transmissionTypesEnum, Integer year, ModelDto model, BrandDto brand) {
        this.description = description;
        this.engineTypesEnum = engineTypesEnum;
        this.mileage = mileage;
        this.price = price;
        this.transmissionTypesEnum = transmissionTypesEnum;
        this.year = year;
        this.model = model;
    }

    public OffersByBrandAndVtypeDto() {
    }

    @Override
    public String toString() {
        return "{" +
                "description='" + description + '\'' +
                ", engine=" + engineTypesEnum +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmissionTypesEnum +
                ", year=" + year +
                ", image=" + model.getImageUrl() +
                ", brand=" + model.getBrand().getName() +
                '}' + "\n";
    }
}
