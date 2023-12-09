package com.example.demo.repos;


import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;
import com.example.demo.web.views.MinimalOfferInfoMV;
import com.example.demo.web.views.OfferDetailsMV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {


    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name, o.id)" +
            "From Offer o JOIN o.model m JOIN o.seller u JOIN Brand b on m.brand.id=b.id ORDER by o.created DESC ")
    List<MinimalOfferInfoMV> getLatestOffers();

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name,o.id ) FROM Offer o JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id WHERE m.category=:vehicleType ")
    List<MinimalOfferInfoMV> getAllOffersByVtype(@Param(value = "vehicleType") VehicleTypesEnum vehicleType);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name,o.id ) FROM Offer o JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id WHERE b.name=:brandName ")
    List<MinimalOfferInfoMV> getAllOffersByBrand(@Param(value = "brandName") String brandName);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name, o.id )" +
            " FROM Offer o JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id WHERE m.name=:modelName ")
    List<MinimalOfferInfoMV> getAllOffersByModel(@Param(value = "modelName") String modelName);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name,o.id ) From Offer o JOIN o.model m JOIN o.seller u JOIN Brand b on m.brand.id=b.id WHERE u.username=:username ")
    List<MinimalOfferInfoMV> getAllOffersByUsername(@Param(value = "username") String username);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name,o.id ) FROM Offer o JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id ")
    List<MinimalOfferInfoMV> getAllOffers();

    @Query(value = "SELECT new com.example.demo.web.views.OfferDetailsMV(o.price, o.mileage, o.year,  m.name, b.name, m.category, u.username, u.active, o.description, o.created, o.transmission, o.engine, o.id) From Offer o JOIN o.model m JOIN o.seller u JOIN Brand b on m.brand.id=b.id WHERE o.id=:id ")
    OfferDetailsMV getOfferDetails(@Param(value = "id") UUID id);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name,o.id )" +
            " FROM Offer o JOIN User u ON o.seller.id=u.id JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id" +
            " WHERE (o.engine IN :engineFilter) AND (o.transmission IN :transmissionFilter) AND (m.category IN :typeFilter) " +
            " AND (o.year BETWEEN :minYear AND :maxYear) AND (o.price BETWEEN :minPrice AND :maxPrice)" +
            " AND ((:modelFilter IS NULL OR m.name = :modelFilter) OR (:brandFilter IS NULL OR b.name = :brandFilter) OR (:usernameFilter IS NULL OR u.username = :usernameFilter))")
    List<MinimalOfferInfoMV> getAllOffersFiltered(@Param("engineFilter") List<EngineTypesEnum> engineFilter,
                                                  @Param("transmissionFilter") List<TransmissionTypesEnum> transmissionFilter,
                                                  @Param("minYear") Integer minYear, @Param("maxYear") Integer maxYear,
                                                  @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice,
                                                  @Param("modelFilter") String model,
                                                  @Param("brandFilter") String brand,
                                                  @Param("typeFilter") List<VehicleTypesEnum> typeFilter,
                                                  @Param("usernameFilter") String username

    );

    void deleteOfferById(UUID id);


}
