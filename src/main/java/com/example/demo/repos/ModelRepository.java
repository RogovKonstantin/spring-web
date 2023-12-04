package com.example.demo.repos;


import com.example.demo.models.Model;
import com.example.demo.web.views.MinimalModelInfoMV;
import com.example.demo.web.views.OfferDetailsMV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    Model findByName(String name);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalModelInfoMV" +
            "(m.name, m.category, m.startYear, m.endYear, b.name) " +
            "From Model m JOIN Brand b on m.brand.id=b.id WHERE b.name=:brandName ")
    List<MinimalModelInfoMV> getModelsByBrand(@Param(value = "brandName") String brandName);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalModelInfoMV" +
            "(m.name) " +
            "From Model m JOIN Brand b on m.brand.id=b.id WHERE b.name=:brandName ")
    List<MinimalModelInfoMV> getModelByBrandName(@Param(value = "brandName")String brand);

}
