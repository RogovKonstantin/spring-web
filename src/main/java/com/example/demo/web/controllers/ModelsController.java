package com.example.demo.web.controllers;

import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.services.BrandService;
import com.example.demo.services.ModelService;
import com.example.demo.web.views.MinimalModelInfoMV;
import com.example.demo.web.views.ModelCreationMV;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelsController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);
    private ModelService modelService;
    private BrandService brandService;


    @GetMapping("/all")
    public String allModels(Model model) {
        LOG.log(Level.INFO, "Show all models");
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        List<MinimalModelInfoMV> modelsAll = modelService.getAllModels();
        model.addAttribute("allModelsList", modelsAll);
        stopWatch1.stop();
        System.out.println(stopWatch1.getTotalTimeMillis());
        return "models-all";
    }

    @GetMapping("/by-brand/{brand}")
    public String allModelsByBrand(@PathVariable String brand, Model model) {
        LOG.log(Level.INFO, "all models by brand"+brand );
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<MinimalModelInfoMV> modelsByBrand = modelService.getAllModelsByBrand(brand);
        model.addAttribute("allModelsList", modelsByBrand);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "models-all";
    }

    @GetMapping("/by-brand-name/{brand}")
    public ResponseEntity<List<MinimalModelInfoMV>> getAllModels(@PathVariable String brand) {
        List<MinimalModelInfoMV> models = modelService.getModelByBrandName(brand);
        return ResponseEntity.status(200).body(models);
    }

    @GetMapping("/create-model")
    public String createModel(Model model) {

        model.addAttribute("Brands", brandService.getAll());
        model.addAttribute("Categories", VehicleTypesEnum.values());
        return "model-creation";
    }

    @ModelAttribute("modelCreationModelAttribute")
    public ModelCreationMV modelCreationMV() {
        return new ModelCreationMV();
    }

    @PostMapping("/create-model")
    public String addBrand(@Valid ModelCreationMV modelCreationMV, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        LOG.log(Level.INFO, "Create model "+modelCreationMV.getName()+" "+modelCreationMV.getBrandName() );
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelCreationModelAttribute", modelCreationMV);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelCreationModelAttribute", bindingResult);
            return "redirect:/models/create-model";
        }
        modelService.createModel(modelCreationMV);
        return "redirect:/models/all";
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

}
