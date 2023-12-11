package com.example.demo.services.impl;


import com.example.demo.models.Brand;
import com.example.demo.repos.BrandRepository;
import com.example.demo.services.BrandService;
import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.web.views.BrandCreationMV;
import com.example.demo.web.views.BrandMV;
import com.example.demo.web.views.ModelCreationMV;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@EnableCaching
@Service
public class BrandServiceImpl implements BrandService {
    private final ModelMapper modelMapper;
    private BrandRepository brandRepository;

    @Autowired
    BrandServiceImpl( ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @CacheEvict(cacheNames = "brands", allEntries = true)
    @Override
    public void createBrand(BrandCreationMV brandCreationMV) {
        brandRepository.saveAndFlush(modelMapper.map(brandCreationMV, Brand.class));
    }
    @Cacheable(value = "brands",key = "#root.methodName")
    @Override
    public List<BrandMV> getAllBrands() {
        return this.getAll().stream().map((brand) -> modelMapper.map(brand, BrandMV.class)).collect(Collectors.toList());
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((brand) -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

}
