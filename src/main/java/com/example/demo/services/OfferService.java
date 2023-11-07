package com.example.demo.services;

import com.example.demo.models.Offer;
import com.example.demo.services.DTOS.OfferDto;
import com.example.demo.web.views.OfferCreationMV;

import com.example.demo.web.views.OfferMV;
import com.example.demo.web.views.OfferModelMV;
import com.example.demo.web.views.OfferUserMV;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    List<OfferDto> getAll();

    void saveAllOffers(List<Offer> offers);

    void saveOffer(Offer offer);


    List<OfferDto> getOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage);


    void deleteOffer(OfferDto offer);

    void deleteOfferById(UUID id);

    OfferDto createOffer(OfferDto offerDto);

    void updatePrice(OfferDto offerDto, Integer price);

    List<OfferMV> viewAllOffers();
    List<OfferMV> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage);


    List<OfferUserMV> viewOffersByActiveUsers();

    void createOffer(OfferCreationMV offerCreationMV);
    List<OfferModelMV> getAllOffersByBrandAndVtype(String brand, String type);

}
