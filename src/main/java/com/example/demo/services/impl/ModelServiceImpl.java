package com.example.demo.services.impl;

import com.example.demo.models.Model;
import com.example.demo.repos.BrandRepository;
import com.example.demo.repos.ModelRepository;
import com.example.demo.services.DTOS.ModelDto;
import com.example.demo.services.ModelService;
import com.example.demo.util.validation.ValidationUtil;
import com.example.demo.web.views.MinimalModelInfoMV;
import com.example.demo.web.views.ModelCreationMV;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@EnableCaching
@Service
public class ModelServiceImpl implements ModelService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private ModelRepository modelRepository;
    private BrandRepository brandRepository;

    @Autowired
    ModelServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveAllModels(List<Model> models) {
        modelRepository.saveAll(models);
    }

    @Override
    public void saveModel(Model model) {
        modelRepository.save(model);
    }

    @Override
    public void deleteModel(ModelDto modelDto) {
        modelRepository.deleteById(modelDto.getId());
        System.out.println("Model " + modelDto.getId() + " deleted");
    }
    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void deleteModelById(UUID id) {
        modelRepository.deleteById(id);
    }

    @Override
    public void updateEndYear(ModelDto modelDto, Integer newEndYear) {

        Model model = modelMapper.map(modelDto, Model.class);
        Integer oldEndYear = model.getEndYear();
        model.setEndYear(newEndYear);
        modelRepository.save(model);
        System.out.println(oldEndYear + " changed to " + newEndYear);


    }

    @Override
    public List<ModelDto> getAll() {
        return modelRepository.findAll()
                .stream().map((model) -> modelMapper.map(model, ModelDto.class)).collect(Collectors.toList());
    }
    @Cacheable(value = "models",key = "#root.methodName")
    @Override
    public List<MinimalModelInfoMV> getAllModels() {
        return modelRepository.getAllModels();
    }

    @Cacheable(value = "models",key = "#root.methodName")
    @Override
    public List<MinimalModelInfoMV> getAllModelsByBrand(String brand) {
        return modelRepository.getModelsByBrand(brand);
    }

    @Override
    public List<MinimalModelInfoMV> getModelByBrandName(String brandName) {
        return modelRepository.getModelByBrandName(brandName);
    }
    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void createModel(ModelCreationMV modelCreationMV) {
        Model model = modelMapper.map(modelCreationMV, Model.class);
        model.setBrand(brandRepository.getBrandByName(modelCreationMV.getBrandName()));
        model.setImageUrl("blank");
        modelRepository.saveAndFlush(model);
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
