package com.example.demo.web.controllers;


import com.example.demo.services.OfferService;
import com.example.demo.web.views.OfferModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController {
    private OfferService offerService;



    @GetMapping("")
    public String allOffers(Model model) {
        List<OfferModelView> offerList = offerService.getAllOffers();
        model.addAttribute("offerList", offerList);
        offerList.forEach(System.out::println);
        return "all-offers.html";
    }


    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;

    }


}
