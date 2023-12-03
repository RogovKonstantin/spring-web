package com.example.demo.web.controllers;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.services.BrandService;
import com.example.demo.services.OfferService;
import com.example.demo.web.views.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OffersController {


    private OfferService offerService;
    private BrandService brandService;


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

    @GetMapping("/by-model/{modelName}")
    public String allOffersByModel(@PathVariable String modelName, Model model) {
        List<MinimalOfferInfoMV> offersByModel = offerService.getAllOffersByModel(modelName);
        model.addAttribute("offers", offersByModel);
        return "offers-all";
    }

    @GetMapping("/by-username/{username}")
    public String allOffersByUsername(@PathVariable String username, Model model) {
        List<MinimalOfferInfoMV> offersByUsername = offerService.getAllOffersByUsername(username);
        model.addAttribute("offers", offersByUsername);
        return "offers-all";
    }

    @GetMapping("/filtered")
    public String allOffersFiltered2(@ModelAttribute("filtersInputMV") FiltersInputMV filtersInputMV,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) String brand,
                                     @RequestParam(required = false) String type,
                                     Model resultModel) {
        List<MinimalOfferInfoMV> offersFiltered = offerService.getFilteredOffers(filtersInputMV, model, brand, type);
        resultModel.addAttribute("offers", offersFiltered);
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


    @GetMapping("/create-offer")
    public String createOffer(Model model) {
        model.addAttribute("Brands", brandService.getAll());
        model.addAttribute("Transmissions", List.of(TransmissionTypesEnum.values()));
        model.addAttribute("Engines", List.of(EngineTypesEnum.values()));
        return "offer-creation";
    }

    @ModelAttribute("newOffer")
    public OfferCreationMV initOffer() {
        return new OfferCreationMV();
    }


    @PostMapping("/create-offer")
    public String registerUser(@Valid OfferCreationMV newOffer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("newOffer", newOffer);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newOffer", bindingResult);
            return "redirect:/offers/create-offer";
        }
        offerService.createOffer(newOffer);
        return "redirect:/";
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

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
