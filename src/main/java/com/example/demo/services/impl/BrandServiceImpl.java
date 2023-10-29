package com.example.demo.services.impl;


import com.example.demo.models.Brand;
import com.example.demo.repos.BrandRepository;
import com.example.demo.services.BrandService;
import com.example.demo.services.DTOS.defaultDTOS.BrandDto;
import com.example.demo.services.DTOS.defaultDTOS.ModelDto;
import com.example.demo.util.ValidationUtil;
import com.example.demo.web.views.BrandModelView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private BrandRepository brandRepository;

    @Autowired
    BrandServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveAllBrands(List<Brand> brands) {
        brandRepository.saveAll(brands);
    }

    @Override
    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public List<ModelDto> getAllBrandModelsInOrderByCategory(String brandName) {
        return brandRepository.getAllBrandModelsInOrderByCategory(brandName).stream().map((o) -> modelMapper.map(o, ModelDto.class)).collect(Collectors.toList());
    }


    @Override
    public void deleteBrand(BrandDto brandDto) {
        brandRepository.deleteById(brandDto.getId());
        System.out.println("Brand " + brandDto.getName() + " deleted");
    }

    @Override
    public void deleteBrandById(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((brand) -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteByName(String name) {
        Brand brand = brandRepository.getBrandByName(name);
        brandRepository.delete(brand);
        System.out.println("Brand " + name + " deleted");
    }

    @Override
    public List<BrandModelView> getAllBrands() {
        return this.getAll().stream().map((brand) -> modelMapper.map(brand, BrandModelView.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

}
