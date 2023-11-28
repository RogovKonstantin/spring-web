package com.example.demo.repos;


import com.example.demo.constants.Enums.EngineTypesEnum;
import com.example.demo.constants.Enums.TransmissionTypesEnum;
import com.example.demo.constants.Enums.VehicleTypesEnum;
import com.example.demo.models.Offer;
import com.example.demo.web.views.MinimalOfferInfoMV;
import com.example.demo.web.views.OfferDetailsMV;
import com.example.demo.web.views.OfferMV;
import com.example.demo.web.views.OfferUserMV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

    @Query(value = "SELECT new com.example.demo.web.views.OfferMV(o.description,  o.price, o.mileage, o.year)FROM Offer o WHERE price <:price and mileage<:mileage ORDER by o.year DESC  ")
    List<OfferMV> getOffersByPriceAndMileageLessDescYear(@Param(value = "price") Integer price, @Param(value = "mileage") Integer mileage);

    @Query(value = "SELECT new com.example.demo.web.views.OfferUserMV(u.username, o.description,  o.price, o.mileage, o.year, m.category, m.name ) " +
            "From Offer o JOIN o.model m JOIN o.seller u WHERE u.active=:bool")
    List<OfferUserMV> getAllOffersAndModelsByUserState(@Param(value = "bool") Boolean bool);

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

    @Query(value = "SELECT new com.example.demo.web.views.OfferDetailsMV(o.price, o.mileage, o.year,  m.name, b.name, m.category, u.username, u.active, o.description, o.created, o.transmission, o.engine) From Offer o JOIN o.model m JOIN o.seller u JOIN Brand b on m.brand.id=b.id WHERE o.id=:id ")
    OfferDetailsMV getOfferDetails(@Param(value = "id") UUID id);

    @Query(value = "SELECT new com.example.demo.web.views.MinimalOfferInfoMV(o.price, o.mileage, o.year,  m.name, b.name,o.id )" +
            " FROM Offer o JOIN Model m ON o.model.id = m.id JOIN Brand b on m.brand.id=b.id" +
            " WHERE (o.engine IN :engineFilter) AND (o.transmission IN :transmissionFilter) " +
            " AND (o.year BETWEEN :minYear AND :maxYear) AND (o.price BETWEEN :minPrice AND :maxPrice) ")
    List<MinimalOfferInfoMV> getAllOffersFiltered(@Param("engineFilter") List<EngineTypesEnum> engineFilter,
                                                  @Param("transmissionFilter") List<TransmissionTypesEnum> transmissionFilter,
                                                  @Param("minYear") Integer minYear, @Param("maxYear") Integer maxYear,
                                                  @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);


}
