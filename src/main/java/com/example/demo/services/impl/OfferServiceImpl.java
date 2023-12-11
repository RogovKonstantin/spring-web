package com.example.demo.services.impl;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;
import com.example.demo.repos.ModelRepository;
import com.example.demo.repos.OfferRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.DTOS.OfferDto;
import com.example.demo.services.ModelService;
import com.example.demo.services.OfferService;
import com.example.demo.services.UserService;
import com.example.demo.web.views.FiltersInputMV;
import com.example.demo.web.views.MinimalOfferInfoMV;
import com.example.demo.web.views.OfferCreationMV;
import com.example.demo.web.views.OfferDetailsMV;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@EnableCaching
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private OfferRepository offerRepository;
    private UserService userService;
    private ModelService modelService;
    private UserRepository userRepository;
    private ModelRepository modelRepository;

    @Autowired
    OfferServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Cacheable(value = "offers",key = "#root.methodName")
    @Override
    public List<MinimalOfferInfoMV> allOffers() {

        return offerRepository.getAllOffers();

    }

    @CacheEvict(cacheNames = "offers", allEntries = true)
    @Override
    public void createOffer(OfferCreationMV newOffer) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Offer offer = modelMapper.map(newOffer, Offer.class);
        offer.setSeller(userRepository.findByUsername(currentPrincipalName));
        offer.setModel(modelRepository.findByName(newOffer.getModelName()));
        offerRepository.saveAndFlush(offer);

    }

    @Override
    public void createOffer(OfferDto offerDto) {
        this.offerRepository.saveAndFlush(this.modelMapper.map(offerDto, Offer.class));
    }

    @Override
    public List<MinimalOfferInfoMV> getOffersSortByDate() {
        return offerRepository.getLatestOffers();
    }
    @Cacheable(value = "offers",key = "#root.methodName")
    @Override
    public List<MinimalOfferInfoMV> getAllOffersByVtype(String type) {
        return offerRepository.getAllOffersByVtype(VehicleTypesEnum.valueOf(type));
    }
    @Cacheable(value = "offers",key = "#root.methodName")
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
    @Cacheable(value = "offers",key = "#root.methodName")
    @Override
    public List<MinimalOfferInfoMV> getAllOffersByModel(String modelName) {
        return offerRepository.getAllOffersByModel(modelName);
    }
    @CacheEvict(cacheNames = "offers", allEntries = true)
    @Override
    @Transactional
    public void deleteOfferByID(UUID id) {
        offerRepository.deleteOfferById(id);
    }


    @Override
    public List<MinimalOfferInfoMV> getFilteredOffers(@Valid FiltersInputMV filtersInputMV, String model, String brand, String type, String username) {
        System.out.println(filtersInputMV);
        List<EngineTypesEnum> enginesFilters;
        List<TransmissionTypesEnum> transmissionsFilters;
        List<VehicleTypesEnum> typesFilters;
        Integer minYear = filtersInputMV.getMinYear();
        Integer minPrice = filtersInputMV.getMinPrice();
        Integer maxYear = filtersInputMV.getMaxYear();
        Integer maxPrice = filtersInputMV.getMaxPrice();


        String engines = filtersInputMV.getEngines();
        String transmissions = filtersInputMV.getTransmissions();

        typesFilters = new ArrayList<>();
        if (type != null) {
            for (String t : type.split(",")) {
                typesFilters.add(VehicleTypesEnum.valueOf(t));
            }
        } else {
            typesFilters = List.of(VehicleTypesEnum.values());
        }

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
        return offerRepository.getAllOffersFiltered(enginesFilters, transmissionsFilters, minYear, maxYear, minPrice, maxPrice, model, brand, typesFilters, username);


    }


    @Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

}
