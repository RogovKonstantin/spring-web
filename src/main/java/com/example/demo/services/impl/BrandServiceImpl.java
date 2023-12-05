package com.example.demo.services.impl;


import com.example.demo.models.Brand;
import com.example.demo.repos.BrandRepository;
import com.example.demo.services.BrandService;
import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.web.views.BrandMV;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelMapper modelMapper;
    private BrandRepository brandRepository;

    @Autowired
    BrandServiceImpl( ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBrand(BrandDto brandDto) {
        brandRepository.saveAndFlush(modelMapper.map(brandDto, Brand.class));
    }

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
