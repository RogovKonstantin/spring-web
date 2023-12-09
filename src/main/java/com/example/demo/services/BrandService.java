package com.example.demo.services;

import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.web.views.BrandCreationMV;
import com.example.demo.web.views.BrandMV;

import java.util.List;

public interface BrandService {


    void createBrand(BrandCreationMV brandCreationMV);

    List<BrandMV> getAllBrands();


    List<BrandDto> getAll();
}
