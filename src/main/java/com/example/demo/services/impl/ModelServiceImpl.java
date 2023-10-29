package com.example.demo.services.impl;

import com.example.demo.models.Model;
import com.example.demo.repos.ModelRepository;
import com.example.demo.services.DTOS.defaultDTOS.ModelDto;
import com.example.demo.services.ModelService;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private ModelRepository modelRepository;

    @Autowired
    ModelServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil=validationUtil;
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

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
