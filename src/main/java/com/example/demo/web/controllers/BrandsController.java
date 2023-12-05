package com.example.demo.web.controllers;

import com.example.demo.services.BrandService;
import com.example.demo.web.views.BrandMV;
import com.example.demo.web.views.BrandModelsMV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
