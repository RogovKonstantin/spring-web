package com.example.demo.repos;


import com.example.demo.models.Brand;
import com.example.demo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Query(value = "SELECT m FROM Model m JOIN Brand b ON m.brand.id = b.id WHERE b.name=:brandName ORDER BY m.category")
    List<Model> getAllBrandModelsInOrderByCategory(@Param(value = "brandName") String brandName);

    @Query(value = "select b FROM Brand b WHERE b.name=:name")
    Brand getBrandByName(@Param(value = "name") String name);
}
