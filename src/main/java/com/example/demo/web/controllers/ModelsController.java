package com.example.demo.web.controllers;

import com.example.demo.services.ModelService;
import com.example.demo.web.views.MinimalModelInfoMV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelsController {
    private ModelService modelService;

    @GetMapping("/by-brand/{brand}")
    public String allOffersByBrand(@PathVariable String brand, Model model) {
        List<MinimalModelInfoMV> modelsByBrand = modelService.getAllModelsByBrand(brand);
        model.addAttribute("allModelsList", modelsByBrand);
        return "models-all";
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
