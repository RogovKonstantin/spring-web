package com.example.demo.services;

import com.example.demo.services.DTOS.OfferDto;
import com.example.demo.web.views.*;

import java.util.List;
import java.util.UUID;

public interface OfferService {


    List<MinimalOfferInfoMV> getFilteredOffers(FiltersInputMV filtersInputMV,String model,String brand,String type, String username);


    void createOffer(OfferDto offerDto);

    List<MinimalOfferInfoMV> allOffers();

    void createOffer(OfferCreationMV offerCreationMV);

    List<MinimalOfferInfoMV> getOffersSortByDate();

    List<MinimalOfferInfoMV> getAllOffersByVtype(String type);

    List<MinimalOfferInfoMV> getAllOffersByBrand(String brandName);

    OfferDetailsMV getOfferDetails(UUID id);

    List<MinimalOfferInfoMV> getAllOffersByUsername(String username);

    List<MinimalOfferInfoMV> getAllOffersByModel(String modelName);

    void deleteOfferByID(UUID id);

}
