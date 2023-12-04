package com.example.demo.web.controllers;

import com.example.demo.services.DTOS.ModelDto;
import com.example.demo.services.ModelService;
import com.example.demo.web.views.MinimalModelInfoMV;
import com.example.demo.web.views.OfferDetailsMV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelsController {

    private ModelService modelService;

    @GetMapping("/by-brand/{brand}")
    public String allModelsByBrand(@PathVariable String brand, Model model) {
        List<MinimalModelInfoMV> modelsByBrand = modelService.getAllModelsByBrand(brand);
        model.addAttribute("allModelsList", modelsByBrand);
        return "models-all";
    }

    @GetMapping("/by-brand-name/{brand}")
    public ResponseEntity<List<MinimalModelInfoMV>> getAllModels(@PathVariable String brand){
        List<MinimalModelInfoMV> models = modelService.getModelByBrandName(brand);
        return ResponseEntity.status(200).body(models);
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
