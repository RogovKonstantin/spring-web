package com.example.demo.services;

import com.example.demo.services.DTOS.ModelDto;
import com.example.demo.models.Model;
import com.example.demo.web.views.MinimalModelInfoMV;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    void saveAllModels(List<Model> models);


    void saveModel(Model model);

    void deleteModel(ModelDto modelDto);

    void deleteModelById(UUID id);
    void updateEndYear(ModelDto modelDto, Integer endYear);

    List<ModelDto> getAll();
    ModelDto getModelDtoByName(String name);

    List<MinimalModelInfoMV> getAllModelsByBrand(String brand);
}

