package com.example.demo.services;

import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;
import com.example.demo.services.DTOS.OffersByBrandAndVtypeDto;
import com.example.demo.services.DTOS.OffersModelsByUserStateDto;
import com.example.demo.services.DTOS.defaultDTOS.OfferDto;
import com.example.demo.services.DTOS.defaultDTOS.UserDto;
import com.example.demo.web.views.CreateOfferMW;
import com.example.demo.web.views.OfferModelView;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    List<OfferDto> getAll();

    void saveAllOffers(List<Offer> offers);

    void saveOffer(Offer offer);

    List<OffersByBrandAndVtypeDto> getAllOffersByBrandAndVtype(String brandName, VehicleTypesEnum vehicleType);

    List<OfferDto> getOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage);

    List<OffersModelsByUserStateDto> getAllOffersAndModelsByUserState(Boolean bool);

    void deleteOffer(OfferDto offer);

    void deleteOfferById(UUID id);

    OfferDto createOffer(OfferDto offerDto);

    void updatePrice(OfferDto offerDto, Integer price);

    List<OfferModelView> viewAllOffers();

    List<OfferModelView> viewAllOffersByBrandAndVtype(String brandName, String vehicleType);
    List<OfferModelView> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage);
    List<OfferModelView> viewOffersByActiveUsers();
    void createOffer(CreateOfferMW createOfferMW);

}
