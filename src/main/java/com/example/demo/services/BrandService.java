package com.example.demo.services;

import com.example.demo.services.DTOS.defaultDTOS.BrandDto;
import com.example.demo.services.DTOS.defaultDTOS.ModelDto;
import com.example.demo.models.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    void saveAllBrands(List<Brand> brands);

    void saveBrand(Brand brand);



    List<ModelDto> getAllBrandModelsInOrderByCategory(String brandName);

    void deleteBrand(BrandDto brand);

    void deleteBrandById(UUID id);

    List<BrandDto> getAll();

    void deleteByName(String name);
}
