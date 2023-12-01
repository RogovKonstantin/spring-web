package com.example.demo.services.impl;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
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
import com.example.demo.web.views.*;
import jakarta.validation.ConstraintViolation;
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
    public List<MinimalOfferInfoMV> allOffers() {
        return offerRepository.getAllOffers();
    }


    /* @Override
    public List<OfferMV> viewAllOffers() {
        List<OfferDto> offerDtoList = offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDto.class))
                .toList();

        List<OfferMV> allOffersDemoView = new ArrayList<>();

        for (OfferDto offerDto : offerDtoList) {

            OfferMV offerMV = modelMapper.map(offerDto, OfferMV.class);

            offerMV.setModel(offerDto.getModel().getName());
            offerMV.setBrand(offerDto.getModel().getBrand().getName());
            offerMV.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoView.add(offerMV);
        }
        return allOffersDemoView;
    }*/
    @Override
    public List<OfferMV> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage) {
        return offerRepository.getOffersByPriceAndMileageLessDescYear(price, mileage);
    }


    @Override
    public List<OfferUserMV> viewOffersByActiveUsers() {
        return offerRepository.getAllOffersAndModelsByUserState(true);

    }

    @Override
    public void createOffer(OfferCreationMV offerCreationMV) {
        if (!this.validationUtil.isValid(offerCreationMV)) {
            this.validationUtil
                    .violations(offerCreationMV)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            OfferDto offerDto = modelMapper.map(offerCreationMV, OfferDto.class);
            ModelDto modelDto = modelService.getModelDtoByName(offerCreationMV.getModel());
            UserDto userDto = userService.getByUsername(offerCreationMV.getSeller());
            offerDto.setModel(modelDto);
            offerDto.setSeller(userDto);
            System.out.println(offerDto);
            this.createOffer(offerDto);
        }

    }

    @Override
    public List<MinimalOfferInfoMV> getOffersSortByDate() {
        return offerRepository.getLatestOffers();
    }

    @Override
    public List<MinimalOfferInfoMV> getAllOffersByVtype(String type) {
        return offerRepository.getAllOffersByVtype(VehicleTypesEnum.valueOf(type));
    }

    @Override
    public List<MinimalOfferInfoMV> getAllOffersByBrand(String brandName) {
        return offerRepository.getAllOffersByBrand(brandName);
    }

    @Override
    public OfferDetailsMV getOfferDetails(UUID id) {
        return offerRepository.getOfferDetails(id);
    }

    @Override
    public List<MinimalOfferInfoMV> getAllOffersByUsername(String username) {
        return offerRepository.getAllOffersByUsername(username);
    }

    @Override
    public List<MinimalOfferInfoMV> getAllOffersByModel(String modelName) {
        return offerRepository.getAllOffersByModel(modelName);
    }


    @Override
    public void deleteOffer(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.getId());
        System.out.println("Offer " + offerDto.getId() + " deleted");
    }

    @Override
    public List<MinimalOfferInfoMV> getFilteredOffers(FiltersInputMV filtersInputMV, String model,String brand) {
        System.out.println(filtersInputMV);
        List<MinimalOfferInfoMV> result;
        List<EngineTypesEnum> enginesFilters;
        List<TransmissionTypesEnum> transmissionsFilters;
        Integer minYear = filtersInputMV.getMinYear();
        Integer minPrice = filtersInputMV.getMinPrice();
        Integer maxYear = filtersInputMV.getMaxYear();
        Integer maxPrice = filtersInputMV.getMaxPrice();


        if (!this.validationUtil.isValid(filtersInputMV)) {
            this.validationUtil
                    .violations(filtersInputMV)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            result = offerRepository.getAllOffers();
        } else {


            String engines = filtersInputMV.getEngines();
            String transmissions = filtersInputMV.getTransmissions();




            enginesFilters = new ArrayList<>();
            if (engines != null) {
                for (String engine : engines.split(",")) {
                    enginesFilters.add(EngineTypesEnum.valueOf(engine));
                }
            } else {
                enginesFilters = List.of(EngineTypesEnum.values());
            }
            transmissionsFilters = new ArrayList<>();
            if (transmissions != null) {
                for (String transmission : transmissions.split(",")) {
                    transmissionsFilters.add(TransmissionTypesEnum.valueOf(transmission));
                }
            } else {
                transmissionsFilters = List.of(TransmissionTypesEnum.values());
            }
            result = offerRepository.getAllOffersFiltered(enginesFilters, transmissionsFilters, minYear, maxYear, minPrice, maxPrice, model,brand);
        }
        return result;
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
