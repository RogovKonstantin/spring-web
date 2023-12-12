package com.example.demo.web.controllers;

import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;

import com.example.demo.services.BrandService;
import com.example.demo.services.OfferService;
import com.example.demo.web.views.*;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/offers")
public class OffersController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    private OfferService offerService;
    private BrandService brandService;


    @GetMapping("")
    public String allOffers(Model model, Principal principal) {
        LOG.log(Level.INFO, "Show all offers for " + principal.getName());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<MinimalOfferInfoMV> offerList = offerService.allOffers();
        model.addAttribute("offers", offerList);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "offers-all";
    }

    @GetMapping("/by-type/{type}")
    public String allOffersByType(@PathVariable String type, Model model) {
        LOG.log(Level.INFO, "Show all offers by specific type:" + type);
        List<MinimalOfferInfoMV> offersByType = offerService.getAllOffersByVtype(type);
        model.addAttribute("offers", offersByType);
        return "offers-all";
    }

    @GetMapping("/by-brand/{brand}")
    public String allOffersByBrand(@PathVariable String brand, Model model) {
        LOG.log(Level.INFO, "Show all offers by specific brand:" + brand);
        List<MinimalOfferInfoMV> offersByBrand = offerService.getAllOffersByBrand(brand);
        model.addAttribute("offers", offersByBrand);
        return "offers-all";
    }

    @GetMapping("/rarest")
    public String rarestOffers(Model model) {
        LOG.log(Level.INFO, "Show top 10 rarest offers");
        List<MinimalOfferInfoMV> rarest = offerService.getTop10RarestOffers();
        model.addAttribute("offers", rarest);
        model.addAttribute("offersRedirected", true);
        return "offers-all";
    }

    @GetMapping("/by-model/{modelName}")
    public String allOffersByModel(@PathVariable String modelName, Model model) {
        LOG.log(Level.INFO, "Show all offers by specific model:" + modelName);
        List<MinimalOfferInfoMV> offersByModel = offerService.getAllOffersByModel(modelName);
        model.addAttribute("offers", offersByModel);
        return "offers-all";
    }

    @GetMapping("/by-username/{username}")
    public String allOffersByUsername(@PathVariable String username, Model model, Principal principal) {
        LOG.log(Level.INFO, "Show all offers by " + username + " to " + principal.getName());
        List<MinimalOfferInfoMV> offersByUsername = offerService.getAllOffersByUsername(username);
        model.addAttribute("offers", offersByUsername);
        return "offers-all";
    }

    @GetMapping("/filtered")
    public String allOffersFiltered2(@ModelAttribute("filtersInputMV") FiltersInputMV filtersInputMV,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) String brand,
                                     @RequestParam(required = false) String type,
                                     @RequestParam(required = false) String username,
                                     Model resultModel) {
        LOG.log(Level.INFO, "Show all offers filtered by " + filtersInputMV.getEngines() + " " + filtersInputMV.getTransmissions() + " " + model + " "
                + brand + " " + type + " " + username);
        List<MinimalOfferInfoMV> offersFiltered = offerService.getFilteredOffers(filtersInputMV, model, brand, type, username);
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
    public String offerDetails(@PathVariable UUID offerId, Model model, Principal principal) {
        LOG.log(Level.INFO, "Show details for offer " + offerId + " to " + principal.getName());
        OfferDetailsMV offerDetails = offerService.getOfferDetails(offerId);
        model.addAttribute("offerDetails", offerDetails);
        model.addAttribute("principal", principal);
        return "offer-details";
    }

    @GetMapping("/delete/{offerId}")
    public String deleteOffer(@PathVariable UUID offerId, Principal principal) {
        LOG.log(Level.INFO, "delete offer " + offerId + " by " + principal.getName());
        String username = principal.getName();
        OfferDetailsMV offerDetails = offerService.getOfferDetails(offerId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

        if (offerDetails.getUsername().equals(username)) {
            offerService.deleteOfferByID(offerId);
            return "redirect:/offers/by-username/" + username;
        } else if (isAdmin) {
            offerService.deleteOfferByID(offerId);
            return "redirect:/offers";
        }

        return "redirect:/error";
    }


    @GetMapping("/create-offer")
    public String createOffer(Model model) {
        model.addAttribute("Brands", brandService.getAll());
        model.addAttribute("Transmissions", List.of(TransmissionTypesEnum.values()));
        model.addAttribute("Engines", List.of(EngineTypesEnum.values()));
        return "offer-creation";
    }

    @ModelAttribute("offerCreationModelAttribute")
    public OfferCreationMV offerCreationMV() {
        return new OfferCreationMV();
    }


    @PostMapping("/create-offer")
    public String registerUser(@Valid OfferCreationMV offerCreationMV, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        LOG.log(Level.INFO, "Create offer by" + offerCreationMV.getUsername());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerCreationModelAttribute", offerCreationMV);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerCreationModelAttribute", bindingResult);
            return "redirect:/offers/create-offer";
        }
        offerService.createOffer(offerCreationMV);
        return "redirect:/";
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
