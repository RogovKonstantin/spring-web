package com.example.demo.services;

import com.example.demo.services.DTOS.BrandDto;
import com.example.demo.web.views.BrandMV;

import java.util.List;

public interface BrandService {


    void addBrand(BrandDto brandDto);

    List<BrandMV> getAllBrands();


    List<BrandDto> getAll();
}
