package com.example.demo.services;

import com.example.demo.models.Offer;
import com.example.demo.services.DTOS.OfferDto;
import com.example.demo.web.views.*;

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

    /*  List<MinimalOfferInfoMV> viewAllOffers();*/


    List<MinimalOfferInfoMV> allOffers();

    List<OfferMV> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage);


    List<OfferUserMV> viewOffersByActiveUsers();

    void createOffer(OfferCreationMV offerCreationMV);

    List<MinimalOfferInfoMV> getOffersSortByDate();

    List<MinimalOfferInfoMV> getAllOffersByVtype(String type);

    List<MinimalOfferInfoMV> getAllOffersByBrand(String brandName);

    OfferDetailsMV getOfferDetails(UUID id);

    List<MinimalOfferInfoMV> getAllOffersByUsername(String username);

}
