package com.example.demo.services.impl;

import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;
import com.example.demo.repos.OfferRepository;
import com.example.demo.services.DTOS.OffersByBrandAndVtypeDto;
import com.example.demo.services.DTOS.OffersModelsByUserStateDto;
import com.example.demo.services.DTOS.defaultDTOS.ModelDto;
import com.example.demo.services.DTOS.defaultDTOS.OfferDto;
import com.example.demo.services.DTOS.defaultDTOS.UserDto;
import com.example.demo.services.ModelService;
import com.example.demo.services.OfferService;
import com.example.demo.services.UserService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.web.views.CreateOfferMW;
import com.example.demo.web.views.OfferModelView;
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
    public List<OffersByBrandAndVtypeDto> getAllOffersByBrandAndVtype(String brandName, VehicleTypesEnum vehicleType) {
        return offerRepository.getAllOffersByBrand(brandName, vehicleType).stream().map((o) -> modelMapper.map(o, OffersByBrandAndVtypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDto> getOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage) {
        return offerRepository.getOffersByPriceAndMileageLessDescYear(price, mileage).stream().map((o) -> modelMapper.map(o, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<OffersModelsByUserStateDto> getAllOffersAndModelsByUserState(Boolean bool) {
        return offerRepository.getAllOffersAndModelsByUserState(bool).stream().map((u) -> modelMapper.map(u, OffersModelsByUserStateDto.class)).collect(Collectors.toList());
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
    public List<OfferModelView> viewAllOffers() {
        List<OfferDto> offerDtoList = offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, OfferDto.class))
                .toList();

        List<OfferModelView> allOffersDemoView = new ArrayList<>();

        for (OfferDto offerDto : offerDtoList) {

            OfferModelView offerModelView = modelMapper.map(offerDto, OfferModelView.class);

            offerModelView.setModel(offerDto.getModel().getName());
            offerModelView.setBrand(offerDto.getModel().getBrand().getName());
            offerModelView.setSeller(offerDto.getSeller().getUsername());
            allOffersDemoView.add(offerModelView);
        }
        return allOffersDemoView;
    }

    @Override
    public List<OfferModelView> viewAllOffersByBrandAndVtype(String brandName, String vehicleType) {
        return offerRepository.getAllOffersByBrand(brandName, VehicleTypesEnum.valueOf(vehicleType)).stream()
                .map(offer -> modelMapper.map(offer, OfferModelView.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferModelView> viewOffersByPriceAndMileageLessDescYear(Integer price, Integer mileage) {
        return offerRepository.getOffersByPriceAndMileageLessDescYear(price, mileage).stream()
                .map(offer -> modelMapper.map(offer, OfferModelView.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferModelView> viewOffersByActiveUsers() {
        return offerRepository.getAllOffersAndModelsByUserState(true).stream()
                .map(offer -> modelMapper.map(offer, OfferModelView.class)).collect(Collectors.toList());
    }

    @Override
    public void createOffer(CreateOfferMW createOfferMW) {
        OfferDto offerDto = modelMapper.map(createOfferMW, OfferDto.class);
        ModelDto modelDto = modelService.getModelDtoByName(createOfferMW.getModel());
        UserDto userDto = userService.getByUsername(createOfferMW.getSeller());
        offerDto.setModel(modelDto);
        offerDto.setSeller(userDto);
        this.createOffer(offerDto);
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
