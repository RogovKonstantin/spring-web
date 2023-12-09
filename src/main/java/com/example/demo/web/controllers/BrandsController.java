package com.example.demo.web.controllers;

import com.example.demo.services.BrandService;
import com.example.demo.web.views.BrandCreationMV;
import com.example.demo.web.views.BrandMV;
import com.example.demo.web.views.BrandModelsMV;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandsController {

    @GetMapping("")
    public String allBrands(Model model) {
        List<BrandMV> allBrandsList = brandService.getAllBrands();
        model.addAttribute("allBrandsList", allBrandsList);
        return "brands-all";
    }
    @GetMapping("/create-brand")
    public String addBrand(Model model) {
        return "brand-creation";
    }

    @ModelAttribute("brandCreationModelAttribute")
    public BrandCreationMV brandCreationMV() {
        return new BrandCreationMV();
    }

    @PostMapping("/create-brand")
    public String addBrand(@Valid BrandCreationMV brandCreationMV, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("brandCreationModelAttribute",brandCreationMV);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandCreationModelAttribute",bindingResult);
            return "redirect:/brands/create-brand";
        }
        brandService.createBrand(brandCreationMV);
        return "redirect:/brands";
    }


    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
