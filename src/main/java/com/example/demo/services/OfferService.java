package com.example.demo.services;

import com.example.demo.models.Offer;
import com.example.demo.services.DTOS.OfferDto;
import com.example.demo.web.views.OfferCreationMW;

import com.example.demo.web.views.OfferMW;
import com.example.demo.web.views.OfferModelMW;
import com.example.demo.web.views.OfferUserMW;

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

    List<OfferMW> viewAllOffers();
    List<OfferMW> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage);


    List<OfferUserMW> viewOffersByActiveUsers();

    void createOffer(OfferCreationMW offerCreationMW);
    List<OfferModelMW> getAllOffersByBrandAndVtype(String brand, String type);

}
