package com.example.demo.services;

import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.services.DTOS.ModelDto;
import com.example.demo.models.Brand;
import com.example.demo.web.views.BrandCreationMW;
import com.example.demo.web.views.BrandModelView;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    void saveAllBrands(List<Brand> brands);

    void saveBrand(Brand brand);


    void addBrand(BrandDto brandDto);

    List<ModelDto> getAllBrandModelsInOrderByCategory(String brandName);

    void deleteBrand(BrandDto brand);

    void deleteBrandById(UUID id);

    List<BrandDto> getAll();

    void deleteByName(String name);
    List<BrandModelView> getAllBrands();

    void addBrand(BrandCreationMW brandCreationMW,String name);
}
