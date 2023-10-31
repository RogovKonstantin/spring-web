package com.example.demo.web.controllers;


import com.example.demo.services.OfferService;
import com.example.demo.web.views.OfferCreationMW;

import com.example.demo.web.views.OfferMW;
import com.example.demo.web.views.OfferModelMW;
import com.example.demo.web.views.OfferUserMW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OffersController {
    private OfferService offerService;


    @GetMapping("")
    public String allOffers(Model model) {
        List<OfferMW> offerList = offerService.viewAllOffers();
        model.addAttribute("offerList", offerList);
        offerList.forEach(System.out::println);
        return "all-offers.html";
    }
    @GetMapping("/less-than-price-and-mileage-desc-year")
    public String allOffersPriceAndMileageLess(@RequestParam Integer price, @RequestParam Integer mileage, Model model) {
        List<OfferMW> offersPriceAndMileageLess = offerService.viewOffersByPriceAndMileageLessDescYear(price, mileage);
        model.addAttribute("offersPriceAndMileageLess", offersPriceAndMileageLess);
        offersPriceAndMileageLess.forEach(System.out::println);
        return "all-offers.html";
    }
    @GetMapping("/by-brand-and-vtype/{brand}/{type}")
    public String allOffersByBrandAndVtype(@PathVariable String brand, @PathVariable String type, Model model) {
        List<OfferModelMW> offersByBrandAndVtype = offerService.getAllOffersByBrandAndVtype(brand, type);
        model.addAttribute("offersByBrandAndVtype", offersByBrandAndVtype);
        offersByBrandAndVtype.forEach(System.out::println);
        return "all-offers.html";
    }

    @GetMapping("by-users-active")
    public String allOffersByActiveUsers(Model model) {
        List<OfferUserMW> offersByActiveUsers = offerService.viewOffersByActiveUsers();
        model.addAttribute("offersByActiveUsers", offersByActiveUsers);
        offersByActiveUsers.forEach(System.out::println);
        return "all-offers.html";
    }

    @PostMapping("")
    public String createOffer(@RequestBody OfferCreationMW createOffer){
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
