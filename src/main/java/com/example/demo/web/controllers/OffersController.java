package com.example.demo.web.controllers;


import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.services.OfferService;
import com.example.demo.web.views.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private OfferService offerService;


    @GetMapping("")
    public String allOffers(Model model) {
        List<MinimalOfferInfoMV> offerList = offerService.allOffers();
        model.addAttribute("offers", offerList);
        return "offers-all";
    }

    @GetMapping("/by-type/{type}")
    public String allOffersByType(@PathVariable String type, Model model) {
        List<MinimalOfferInfoMV> offersByType = offerService.getAllOffersByVtype(type);
        model.addAttribute("offers", offersByType);
        return "offers-all";
    }

    @GetMapping("/by-brand/{brand}")
    public String allOffersByBrand(@PathVariable String brand, Model model) {
        List<MinimalOfferInfoMV> offersByBrand = offerService.getAllOffersByBrand(brand);
        model.addAttribute("offers", offersByBrand);
        return "offers-all";
    }

    @GetMapping("/by-username/{username}")
    public String allOffersByUsername(@PathVariable String username, Model model) {
        List<MinimalOfferInfoMV> offersByUsername = offerService.getAllOffersByUsername(username);
        model.addAttribute("offers", offersByUsername);
        return "offers-all";
    }

    @GetMapping("/filtered1")
    public String allOffersFiltered1(
            @RequestParam(name = "engines", required = false) String engines,
            @RequestParam(name = "transmissions", required = false) String transmissions,
            @RequestParam(name = "minYear", required = false) Integer minYear,
            @RequestParam(name = "maxYear", required = false) Integer maxYear,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
            Model model
    ) {

        FiltersInputMV filtersInputMV=new FiltersInputMV();
        filtersInputMV.setEngines(engines);
        filtersInputMV.setTransmissions(transmissions);
        filtersInputMV.setMinPrice(minPrice);
        filtersInputMV.setMaxPrice(maxPrice);
        filtersInputMV.setMinYear(minYear);
        filtersInputMV.setMaxYear(maxYear);

        List<MinimalOfferInfoMV> offersFiltered = offerService.getFilteredOffers(filtersInputMV);

        model.addAttribute("offers",offersFiltered );
        return "offers-all";

    }
    @GetMapping("/filtered2")
    public String allOffersFiltered2(
            @ModelAttribute("filtersInputMV") FiltersInputMV filtersInputMV,
            Model model
    ) {
        List<MinimalOfferInfoMV> offersFiltered = offerService.getFilteredOffers(filtersInputMV);
        offersFiltered.forEach(System.out::println);
        model.addAttribute("offers", offersFiltered);
        return "offers-all";
    }

    @GetMapping("/latest")
    public String allOffersSortedByDate(Model model) {
        List<MinimalOfferInfoMV> offersSortedByDate = offerService.getOffersSortByDate();
        model.addAttribute("offers", offersSortedByDate);
        return "offers-all";
    }

    @GetMapping("/details/{offerId}")
    public String offerDetails(@PathVariable UUID offerId, Model model) {
        OfferDetailsMV offerDetails = offerService.getOfferDetails(offerId);
        model.addAttribute("offerDetails", offerDetails);
        return "offer-details";
    }


    @GetMapping("/less-than-price-and-mileage-desc-year")
    public String allOffersPriceAndMileageLess(@RequestParam Integer price, @RequestParam Integer mileage, Model model) {
        List<OfferMV> offersPriceAndMileageLess = offerService.viewOffersByPriceAndMileageLessDescYear(price, mileage);
        model.addAttribute("offersPriceAndMileageLess", offersPriceAndMileageLess);
        offersPriceAndMileageLess.forEach(System.out::println);
        return "all-offers.html";
    }


    @GetMapping("by-users-active")
    public String allOffersByActiveUsers(Model model) {
        List<OfferUserMV> offersByActiveUsers = offerService.viewOffersByActiveUsers();
        model.addAttribute("offersByActiveUsers", offersByActiveUsers);
        offersByActiveUsers.forEach(System.out::println);
        return "all-offers.html";
    }


    @PostMapping("")
    public String createOffer(@RequestBody OfferCreationMV createOffer) {
        offerService.createOffer(createOffer);
        return "all-offers.html";
    }

    @DeleteMapping("")
    public String deleteOffer(@RequestParam String uuid) {
        offerService.deleteOfferById(UUID.fromString(uuid));
        return "all-offers.html";
    }

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }


}
