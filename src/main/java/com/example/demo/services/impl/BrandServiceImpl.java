package com.example.demo.services.impl;


import com.example.demo.models.Brand;
import com.example.demo.repos.BrandRepository;
import com.example.demo.services.BrandService;
import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.util.validation.ValidationUtil;
import com.example.demo.web.views.BrandCreationMV;
import com.example.demo.web.views.BrandMV;
import com.example.demo.web.views.BrandModelsMV;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void addBrand(BrandDto brandDto) {
        Brand brand = modelMapper.map(brandDto, Brand.class);
        brandRepository.saveAndFlush(brand);
    }


    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((brand) -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }


    @Override
    public List<BrandMV> getAllBrands() {
        return this.getAll().stream().map((brand) -> modelMapper.map(brand, BrandMV.class)).collect(Collectors.toList());
    }

    @Override
    public List<BrandModelsMV> getAllBrandModelsSortedByCategory(String brandName) {
        List<BrandMV> allBrandsList = this.getAllBrands();
        if (!allBrandsList.toString().contains(brandName)) {
            System.out.println("There is no brand called " + brandName);
        }
        return brandRepository.getAllBrandModelsSortedByCategory(brandName);
    }

    @Override
    public void createBrand(String name) {
        BrandCreationMV brandCreation = new BrandCreationMV(name);
        if (!this.validationUtil.isValid(brandCreation)) {
            this.validationUtil
                    .violations(brandCreation)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            System.out.println(brandCreation);
            brandRepository.saveAndFlush(modelMapper.map(brandCreation, Brand.class));
        }
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

}
