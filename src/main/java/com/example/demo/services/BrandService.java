package com.example.demo.services;

import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.services.DTOS.ModelDto;
import com.example.demo.models.Brand;
import com.example.demo.web.views.BrandCreationMV;
import com.example.demo.web.views.BrandMV;
import com.example.demo.web.views.BrandModelsMV;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    void saveAllBrands(List<Brand> brands);
    void saveBrand(Brand brand);
    void addBrand(BrandDto brandDto);
    List<BrandDto> getAll();
    List<BrandMV> getAllBrands();
    List<BrandModelsMV> getAllBrandModelsSortedByCategory(String brandName);
    void createBrand(String name);
}
