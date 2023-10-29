package com.example.demo.web.controllers;

import com.example.demo.services.BrandService;
import com.example.demo.web.views.BrandModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandsController {
    private BrandService brandService;


    @GetMapping("")
    public String AllBrands(Model model) {
        List<BrandModelView> brandList = brandService.getAllBrands();
        model.addAttribute("brandList", brandList);
        brandList.forEach(System.out::println);
        return "all-brands.html";
    }

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
