package com.example.demo.services.impl;

import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;
import com.example.demo.repos.OfferRepository;
import com.example.demo.services.DTOS.ModelDto;
import com.example.demo.services.DTOS.OfferDto;
import com.example.demo.services.DTOS.UserDto;
import com.example.demo.services.ModelService;
import com.example.demo.services.OfferService;
import com.example.demo.services.UserService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.web.views.OfferCreationMW;
import com.example.demo.web.views.OfferMW;
import com.example.demo.web.views.OfferModelMW;
import com.example.demo.web.views.OfferUserMW;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private OfferRepository offerRepository;
    private UserService userService;
    private ModelService modelService;

    @Autowired
    OfferServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<OfferDto> getAll() {
        return offerRepository.findAll()
                .stream().map((offer) -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public void saveAllOffers(List<Offer> offers) {
        offerRepository.saveAll(offers);
    }

    @Override
    public void saveOffer(Offer offer) {
        offerRepository.save(offer);
    }


    @Override
    public List<OfferDto> getOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage) {
        return offerRepository.getOffersByPriceAndMileageLessDescYear(price, mileage).stream().map((o) -> modelMapper.map(o, OfferDto.class)).collect(Collectors.toList());
    }


    @Override
    public OfferDto createOffer(OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        return modelMapper.map(offerRepository.save(offer), OfferDto.class);
    }

    @Override
    public void updatePrice(OfferDto offerDto, Integer newPrice) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        Integer oldPrice = offer.getPrice();
        offer.setPrice(newPrice);
        offerRepository.save(offer);
        System.out.println(oldPrice + " changed to " + newPrice);
    }

    @Override
    public List<OfferMW> viewAllOffers() {
        List<OfferDto> offerDtoList = offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDto.class))
                .toList();

        List<OfferMW> allOffersDemoView = new ArrayList<>();

        for (OfferDto offerDto : offerDtoList) {

            OfferMW offerMW = modelMapper.map(offerDto, OfferMW.class);

            offerMW.setModel(offerDto.getModel().getName());
            offerMW.setBrand(offerDto.getModel().getBrand().getName());
            offerMW.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoView.add(offerMW);
        }
        return allOffersDemoView;
    }

    @Override
    public List<OfferMW> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage) {
        return offerRepository.getOffersByPriceAndMileageLessDescYear(price, mileage);
    }


    @Override
    public List<OfferUserMW> viewOffersByActiveUsers() {
        return offerRepository.getAllOffersAndModelsByUserState(true);

    }

    @Override
    public void createOffer(OfferCreationMW offerCreationMW) {
        OfferDto offerDto = modelMapper.map(offerCreationMW, OfferDto.class);
        ModelDto modelDto = modelService.getModelDtoByName(offerCreationMW.getModel());
        UserDto userDto = userService.getByUsername(offerCreationMW.getSeller());
        offerDto.setModel(modelDto);
        offerDto.setSeller(userDto);
        this.createOffer(offerDto);
    }

    @Override
    public List<OfferModelMW> getAllOffersByBrandAndVtype(String brand, String type) {
        return offerRepository.getAllOffersByBrandAndVtype(brand, VehicleTypesEnum.valueOf(type));
    }


    @Override
    public void deleteOffer(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.getId());
        System.out.println("Offer " + offerDto.getId() + " deleted");
    }

    @Override
    public void deleteOfferById(UUID id) {
        offerRepository.deleteById(id);
    }

    @Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
